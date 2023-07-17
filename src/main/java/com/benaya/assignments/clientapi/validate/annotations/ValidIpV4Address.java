package com.benaya.assignments.clientapi.validate.annotations;

import com.benaya.assignments.clientapi.validate.validators.IpV4Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IpV4Validator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIpV4Address {
    String message() default "Invalid IP address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
