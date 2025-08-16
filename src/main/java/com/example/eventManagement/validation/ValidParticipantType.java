package com.example.eventManagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER }) // ✅ FIELD is included
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParticipantTypeValidator.class)
@Documented

public @interface ValidParticipantType {
    String message() default "Invalid participant type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
