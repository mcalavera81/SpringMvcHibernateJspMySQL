package com.example.controller;

import com.example.domain.JavaSkills;
import com.example.domain.User;
import com.example.service.user.UserService;
import com.example.service.exception.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
@SessionAttributes({"counter"})
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    private final UserService userService;

    @Inject
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("counter")
    public Integer counter(){return 0;}

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody final User user) {
        LOGGER.debug("Received request to create the {}", user);
        return userService.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }

    @RequestMapping(value = "/poll", method = RequestMethod.GET)
    public Integer pollCounter(@ModelAttribute("counter") Integer counter, Map<String, Object> model) {
        LOGGER.debug("Received request to poll counter");
        model.put("counter", ++counter);
        return counter;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

}