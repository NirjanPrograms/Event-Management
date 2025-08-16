package com.example.eventManagement.validation;

import com.example.eventManagement.dto.event.EventDTO;
import com.example.eventManagement.model.Event;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EventDatesValidator implements ConstraintValidator <ValidEventDates, EventDTO>{

    @Override
    public boolean isValid(EventDTO event, ConstraintValidatorContext context) {
        if (event.getEventStartDateTime() == null || event.getEventEndDateTime() == null) {
            return true; // Let @NotNull handle null validation
        }
        return event.getEventEndDateTime().isAfter(event.getEventStartDateTime());
    }

}
