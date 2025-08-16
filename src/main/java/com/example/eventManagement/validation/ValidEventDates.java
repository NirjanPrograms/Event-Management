package com.example.eventManagement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EventDatesValidator.class)
@Documented

public @interface ValidEventDates {

    String message() default "Event end date & time must be after the start date & time";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
