package com.benaya.assignments.clientapi.validate.validators;

import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsraeliIdValidator implements ConstraintValidator<ValidIsraeliId, String> {
    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        int total = 0;
        String paddedId = String.format("%09d", Integer.parseInt(id));
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(paddedId.charAt(i));
            if (i % 2 == 0) { // Odd-position digits
                total += digit;
            } else { // Even-position digits
                digit *= 2;
                total += (digit > 9) ? digit - 9 : digit;
            }
        }
        return total % 10 == 0;
    }

    @Override
    public void initialize(ValidIsraeliId constraintAnnotation) {
    }
}
