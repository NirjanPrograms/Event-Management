package com.example.eventManagement.validation;

import com.example.eventManagement.enums.ParticipantType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParticipantTypeValidator implements ConstraintValidator<ValidParticipantType, ParticipantType> {

    @Override
    public boolean isValid(ParticipantType value, ConstraintValidatorContext context) {
        return value != null && (value == ParticipantType.ARTIST ||
                value == ParticipantType.ORGANIZER ||
                value == ParticipantType.ATTENDEE);
    }
}
