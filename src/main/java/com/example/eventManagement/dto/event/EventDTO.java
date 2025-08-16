package com.example.eventManagement.dto.event;

import com.example.eventManagement.enums.EventStatus;
import com.example.eventManagement.validation.ValidEventDates;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@ValidEventDates // This annotation will validate the endDateTime should be after the StartDateTime
public class EventDTO {

    @NotBlank(message = "Event Name is required!")
    @Size (min = 5, max = 30)
    private String eventName;
    @NotBlank(message = "Event Description is required!")
    @Size(max = 500)
    private String description;
    private String category;
    private String eventBanner;

    @Future(message = "Event start time must be in future")
    @NotNull(message = "Event Start time is required!")
    private LocalDateTime eventStartDateTime;


    private LocalDateTime eventEndDateTime;


    private String locationName;
    private String address;
    private String city;
    private String state;
    private String country;
    @NotBlank(message = "Postal Code is required!")
    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid Postal code")
    private String postalCode;

    @NotNull(message = "Artist id is required!")
    private Long artistId;

    @NotNull(message = "Organizer id is required!")
    private Long organizerId;

    @NotNull(message = "Capacity is required!")
    @Min(value = 10, message = "Minimum capacity is 10")
    @Max(value = 1000, message = "Minimum capacity is 1000")
    private Integer capacity;
    @NotNull(message = "Ticket price is required!")
    private Double ticketPrice;
    private boolean isFree;
    private EventStatus status;

    public EventDTO(String eventName, String description, String category, String eventBanner, LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime, String locationName, String address, String city, String state, String country, String postalCode, Long artistId, Long organizerId, Integer capacity, Double ticketPrice, boolean isFree, EventStatus status) {
        this.eventName = eventName;
        this.description = description;
        this.category=category;
        this.eventBanner = eventBanner;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.locationName = locationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.artistId = artistId;
        this.organizerId = organizerId;
        this.capacity = capacity;
        this.ticketPrice = ticketPrice;
        this.isFree = isFree;
        this.status=status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEventBanner() {
        return eventBanner;
    }

    public void setEventBanner(String eventBanner) {
        this.eventBanner = eventBanner;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
