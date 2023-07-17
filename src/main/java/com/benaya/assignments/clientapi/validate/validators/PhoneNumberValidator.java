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
        String regex = "^\\+972\\s(5\\d\\s\\d{7}|[2-4]\\d\\s\\d{6})$";
//        String regex = "^[0-9]{10,15}$";
        return phoneNumber.matches(regex);
    }

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }
}
