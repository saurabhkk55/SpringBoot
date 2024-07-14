package com.web.webApplication.department.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Long> {
    @Override
    public boolean isValid(Long num, ConstraintValidatorContext context) {
        return isPrime(num);
    }

    private boolean isPrime(Long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
