package com.example.validator;

import com.example.domain.UserCreateForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserCreateFormPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCreateForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;

        if (!form.getPassword1().equals(form.getPassword2())) {
            errors.rejectValue("password2", "user.error.password.no_match");
        }

        if(form.getCountry().equals(0)){
            errors.rejectValue("country", "user.error.country.empty");
        }

        if(form.getSkills().size()<2){
            errors.rejectValue("skills", "user.error.skills", new Object[]{2}, "Oops!");
        }


    }
}