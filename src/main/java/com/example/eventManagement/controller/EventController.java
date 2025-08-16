package com.example.eventManagement.controller;


import com.example.eventManagement.dto.event.EventDTO;
import com.example.eventManagement.services.serviceImpl.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventServiceImpl eventService;

    EventController(EventServiceImpl eventService){
        this.eventService=eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById (@PathVariable Long id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEventById(@PathVariable Long id, @Valid @RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.updateEventById(id, eventDTO));
    }
}
