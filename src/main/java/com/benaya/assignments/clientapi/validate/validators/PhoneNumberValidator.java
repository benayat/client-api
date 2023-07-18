package com.benaya.assignments.clientapi.validate.validators;

import com.benaya.assignments.clientapi.validate.annotations.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return true;
        }
        String regex = "^\\+?(972|0)(\\-)?0?(([23489]{1}\\d{7})|[5]{1}\\d{8})$";
        return phoneNumber.matches(regex);
    }

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }
}
