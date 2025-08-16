package com.example.eventManagement.controller;

import com.example.eventManagement.dto.participant.ParticipantDTO;
import com.example.eventManagement.services.serviceImpl.ParticipantServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    private final ParticipantServiceImpl participantService;

    ParticipantController (ParticipantServiceImpl participantService){
        this.participantService=participantService;
    }

    @PostMapping
    public ResponseEntity<ParticipantDTO> registerParticipant(@Valid @RequestBody ParticipantDTO participantDTO){
        return ResponseEntity.ok(participantService.registerParticipant(participantDTO));
    }

    @GetMapping
    public ResponseEntity<List<ParticipantDTO>> getAllParticipants(){
        return ResponseEntity.ok(participantService.getAllParticipants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDTO> getParticipantById(@PathVariable Long id){
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDTO> updateParticipant(@PathVariable Long id, @Valid @RequestBody ParticipantDTO participantDTO){
        return ResponseEntity.ok(participantService.updateParticipant(id, participantDTO));
    }
}
