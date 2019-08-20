package com.codingdojo.authentication.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.authentication.models.User;

@Component
public class UserValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> class1) {
        return User.class.equals(class1);
    }
    
	@Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }

    

	
}