package com.example.eventManagement.services.serviceImpl;

import com.example.eventManagement.dto.participant.ParticipantDTO;
import com.example.eventManagement.exception.ResourceNotFoundException;
import com.example.eventManagement.model.Participant;
import com.example.eventManagement.repository.ParticipantRepo;
import com.example.eventManagement.services.ParticipantService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepo participantRepo;

    ParticipantServiceImpl(ParticipantRepo participantRepo){
        this.participantRepo=participantRepo;
    }


    @Override
    public ParticipantDTO toParticipantDTO(Participant participant){
        return new ParticipantDTO(
                participant.getFullName(),
                participant.getParticipantType(),
                participant.getEmail(),
                participant.getPhoneNumber(),
                participant.getAddress(),
                participant.getCity(),
                participant.getState(),
                participant.getCountry(),
                participant.getPostalCode(),
                participant.getDateOfBirth(),
                participant.getBiography(),
                participant.getProfilePictureurl()
        );
    }


    @Override
    public ParticipantDTO registerParticipant(ParticipantDTO participantDTO) {
        Participant participant = new Participant(
                participantDTO.getFullName(),
                participantDTO.getParticipantType(),
                participantDTO.getEmail(),
                participantDTO.getPhoneNumber(),
                participantDTO.getAddress(),
                participantDTO.getCity(),
                participantDTO.getState(),
                participantDTO.getCountry(),
                participantDTO.getPostalCode(),
                participantDTO.getDateOfBirth(),
                participantDTO.getBiography(),
                participantDTO.getProfilePictureurl(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        participantRepo.save(participant);
        return toParticipantDTO(participant);
    }

    @Override
    public List<ParticipantDTO> getAllParticipants() {
        if(participantRepo.findAll().isEmpty()){
            throw new ResourceNotFoundException("No Records Found!");
        }
        return participantRepo.findAll().stream()
                .map(this::toParticipantDTO).toList();
    }

    @Override
    public ParticipantDTO getParticipantById(Long id) {
        Participant participant = participantRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
        return toParticipantDTO(participant);
    }

    @Override
    public ParticipantDTO updateParticipant(Long id, ParticipantDTO participantDTO) {
        Participant participant = participantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
        participant.setFullName(participantDTO.getFullName());
        participant.setParticipantType(participantDTO.getParticipantType());
        participant.setEmail(participantDTO.getEmail());
        participant.setPhoneNumber(participantDTO.getPhoneNumber());
        participant.setAddress(participantDTO.getAddress());
        participant.setCity(participantDTO.getCity());
        participant.setState(participantDTO.getState());
        participant.setCountry(participantDTO.getCountry());
        participant.setPostalCode(participantDTO.getPostalCode());
        participant.setDateOfBirth(participantDTO.getDateOfBirth());
        participant.setBiography(participantDTO.getBiography());
        participant.setProfilePictureurl(participantDTO.getProfilePictureurl());
        participant.setUpdatedAt(LocalDateTime.now());
        participantRepo.save(participant);
        return toParticipantDTO(participant);
    }
}
