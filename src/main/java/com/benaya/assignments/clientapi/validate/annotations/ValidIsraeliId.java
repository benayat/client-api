package com.benaya.assignments.clientapi.validate.annotations;

import com.benaya.assignments.clientapi.validate.validators.IsraeliIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsraeliIdValidator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIsraeliId {
    String message() default "Invalid Israeli ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
