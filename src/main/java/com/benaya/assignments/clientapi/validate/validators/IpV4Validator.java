package com.benaya.assignments.clientapi.validate.validators;

import com.benaya.assignments.clientapi.validate.annotations.ValidIpV4Address;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IpV4Validator implements ConstraintValidator<ValidIpV4Address, String> {
    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return IPV4_PATTERN.matcher(value).matches();
    }

    @Override
    public void initialize(ValidIpV4Address constraintAnnotation) {
    }
}
