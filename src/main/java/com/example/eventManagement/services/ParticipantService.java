package com.example.eventManagement.services;

import com.example.eventManagement.dto.participant.ParticipantDTO;
import com.example.eventManagement.model.Participant;

import java.util.List;

public interface ParticipantService {

    ParticipantDTO toParticipantDTO(Participant participant);

    ParticipantDTO registerParticipant(ParticipantDTO participantDTO);

    List<ParticipantDTO> getAllParticipants();

    ParticipantDTO getParticipantById(Long id);

    ParticipantDTO updateParticipant(Long id, ParticipantDTO participantDTO);
}
