package com.example.eventManagement.services.serviceImpl;

import com.example.eventManagement.dto.event.EventDTO;
import com.example.eventManagement.enums.ParticipantType;
import com.example.eventManagement.exception.ResourceNotFoundException;
import com.example.eventManagement.model.Event;
import com.example.eventManagement.model.Participant;
import com.example.eventManagement.repository.EventRepo;
import com.example.eventManagement.repository.ParticipantRepo;
import com.example.eventManagement.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final ParticipantRepo participantRepo;

    EventServiceImpl (EventRepo eventRepo, ParticipantRepo participantRepo){
        this.eventRepo=eventRepo;
        this.participantRepo=participantRepo;
    }

    @Override
    public EventDTO toEventDTO(Event event){
        return new EventDTO(
                event.getEventName(),
                event.getDescription(),
                event.getCategory(),
                event.getEventBanner(),
                event.getEventStartDateTime(),
                event.getEventEndDateTime(),
                event.getLocationName(),
                event.getAddress(),
                event.getCity(),
                event.getState(),
                event.getCountry(),
                event.getPostalCode(),
                event.getArtist().getId(),
                event.getOrganizer().getId(),
                event.getCapacity(),
                event.getTicketPrice(),
                event.isFree(),
                event.getStatus()
        );
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setEventName(eventDTO.getEventName());
        event.setDescription(eventDTO.getDescription());
        event.setCategory(eventDTO.getCategory());
        event.setEventBanner(eventDTO.getEventBanner());
        event.setEventStartDateTime(eventDTO.getEventStartDateTime());
        event.setEventEndDateTime(eventDTO.getEventEndDateTime());
        event.setLocationName(eventDTO.getLocationName());
        event.setAddress(eventDTO.getAddress());
        event.setCity(eventDTO.getCity());
        event.setState(eventDTO.getState());
        event.setCountry(eventDTO.getCountry());
        event.setPostalCode(eventDTO.getPostalCode());
        event.setCapacity(eventDTO.getCapacity());
        event.setTicketPrice(eventDTO.getTicketPrice());
        event.setFree(eventDTO.isFree());
        event.setStatus(eventDTO.getStatus());

        Participant artist = participantRepo.findById(eventDTO.getArtistId())
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        if (artist.getParticipantType() != ParticipantType.ARTIST) {
            throw new IllegalArgumentException("Selected participant is not an artist");
        }
        Participant organizer = participantRepo.findById(eventDTO.getOrganizerId())
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
        if (organizer.getParticipantType() != ParticipantType.ORGANIZER) {
            throw new IllegalArgumentException("Selected participant is not an organizer");
        }

        event.setArtist(artist);
        event.setOrganizer(organizer);

        eventRepo.save(event);
        return toEventDTO(event);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        if(eventRepo.findAll().isEmpty()){
            throw new ResourceNotFoundException("No Records Found!");
        }
        return eventRepo.findAll().stream()
                .map(this::toEventDTO).toList();
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
        return toEventDTO(event);
    }

    @Override
    public EventDTO updateEventById(Long id, EventDTO eventDTO) {
        Event event = eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
        event.setEventName(eventDTO.getEventName());
        event.setDescription(eventDTO.getDescription());
        event.setCategory(eventDTO.getCategory());
        event.setEventBanner(eventDTO.getEventBanner());
        event.setEventStartDateTime(eventDTO.getEventStartDateTime());
        event.setEventEndDateTime(eventDTO.getEventEndDateTime());
        event.setLocationName(eventDTO.getLocationName());
        event.setAddress(eventDTO.getAddress());
        event.setCity(eventDTO.getCity());
        event.setState(eventDTO.getState());
        event.setCountry(eventDTO.getCountry());
        event.setPostalCode(eventDTO.getPostalCode());
        event.setCapacity(eventDTO.getCapacity());
        event.setTicketPrice(eventDTO.getTicketPrice());
        event.setFree(eventDTO.isFree());
        event.setStatus(eventDTO.getStatus());

        Participant artist = participantRepo.findById(eventDTO.getArtistId())
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        if (artist.getParticipantType() != ParticipantType.ARTIST) {
            throw new IllegalArgumentException("Selected participant is not an artist");
        }
        Participant organizer = participantRepo.findById(eventDTO.getOrganizerId())
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
        if (organizer.getParticipantType() != ParticipantType.ORGANIZER) {
            throw new IllegalArgumentException("Selected participant is not an organizer");
        }

        event.setArtist(artist);
        event.setOrganizer(organizer);

        eventRepo.save(event);
        return toEventDTO(event);
    }
}
