package com.example.eventManagement.services;

import com.example.eventManagement.dto.event.EventDTO;
import com.example.eventManagement.model.Event;

import java.util.List;

public interface EventService {

    EventDTO toEventDTO(Event event);

    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    EventDTO updateEventById(Long id, EventDTO eventDTO);
}
