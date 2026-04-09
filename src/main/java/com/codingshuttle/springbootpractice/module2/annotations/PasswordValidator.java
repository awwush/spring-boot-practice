package com.codingshuttle.springbootpractice.module2.annotations;

import com.codingshuttle.springbootpractice.module2.exception.PasswordInvalidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if (password == null || password.length() < 10) {
            throw new PasswordInvalidException("Password is invalid.");
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;

        String specialChars = "@#$%^&+=!_?(){}[]-";

        for (char ch: password.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if(Character.isLowerCase(ch)) {
                hasLower = true;
            } else if(specialChars.contains(String.valueOf(ch))) {
                hasSpecial = true;
            }
        }
        if (!(hasUpper && hasLower && hasSpecial)) {
            throw new PasswordInvalidException("Password is invalid.");
        } else
            return true;
    }
}
