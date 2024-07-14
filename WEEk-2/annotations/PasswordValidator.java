package com.web.webApplication.department.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return isPasswordValid(password);
    }

    private boolean isPasswordValid(String password) {
        // Check if the password contains at least one uppercase letter.
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);

        // Check if the password contains at least one lowercase letter.
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);

        // Check if the password contains at least one special character.
        // A special character is defined as any character that is not a letter or digit.
        boolean hasSpecialChar = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

        // Check if the password has a minimum length of 10 characters.
        boolean isAtLeast10 = password.length() >= 10;

        // The password is valid only if it meets all the above criteria.
        return hasUppercase && hasLowercase && hasSpecialChar && isAtLeast10;
    }
}
