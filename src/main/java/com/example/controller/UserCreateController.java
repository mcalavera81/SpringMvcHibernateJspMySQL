package com.example.controller;

import com.example.domain.Country;
import com.example.domain.JavaSkills;
import com.example.domain.User;
import com.example.domain.UserCreateForm;
import com.example.service.country.CountryService;
import com.example.service.skill.SkillService;
import com.example.service.user.UserService;
import com.example.service.exception.UserAlreadyExistsException;
import com.example.validator.UserCreateFormPasswordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("gender")
public class UserCreateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateController.class);
    private final UserService userService;
    private final CountryService countryService;
    private final UserCreateFormPasswordValidator passwordValidator;
    private final SkillService skillService;

    @Inject
    public UserCreateController(UserService userService,
                                CountryService countryService,
                                SkillService skillService,
                                UserCreateFormPasswordValidator passwordValidator) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
        this.countryService = countryService;
        this.skillService = skillService;
    }

    @InitBinder("user_form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordValidator);
    }

    @ModelAttribute("gender")
    public Map<String,String> gender(){
        Map<String,String> gender = new LinkedHashMap<String,String>();
        gender.put("M", "Male");
        gender.put("F", "Female");
        return gender;
    }

    @ModelAttribute("javaSkills")
    public List<JavaSkills> skills(){
        return skillService.getAllSkills();
    }

    @ModelAttribute("countryList")
    public List<Country> countries(){
        return countryService.getAllCountries();
    }

    @RequestMapping(value = "/user_create.html", method = RequestMethod.GET)
    public ModelAndView getCreateUserView() {
        LOGGER.debug("Received request for user create view");
        ModelAndView mav = new ModelAndView("user_create");

        mav.addObject("user_form", new UserCreateForm());

        return mav;
    }

    @RequestMapping(value = "/user_create.html", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user_form")  @Valid UserCreateForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}, with result={}", form, result);
        if (result.hasErrors()) {
            return "user_create";
        }
        try {
            userService.save(new User(form.getId(), form.getPassword2(), form.getGender(), form.getCountry() , form.getSkills() ));
        } catch (UserAlreadyExistsException e) {
            LOGGER.debug("Tried to create user with existing id", e);
            result.reject("user.error.exists");
            return "user_create";
        }
        return "redirect:/user_list.html";
    }

}