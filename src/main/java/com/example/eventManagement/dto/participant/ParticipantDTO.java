package com.example.eventManagement.dto.participant;

import com.example.eventManagement.enums.ParticipantType;
import com.example.eventManagement.validation.ValidParticipantType;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

public class ParticipantDTO {

    @NotBlank(message = "Participant name is required!")
    private String fullName;

    @NotNull(message = "Participant Type is required!")
    @ValidParticipantType(message = "Invalid participation type")
    private ParticipantType participantType;

    @Email(message = "Invalid email address!")
    @NotBlank(message = "Participant email id is required!")
    private String email;

    @NotBlank(message = "Phone number is required!")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone number")
    private String phoneNumber;

    private String address;
    private String city;
    private String state;
    private String country;
    @NotBlank(message = "Postal Code is required!")
    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid Postal code")
    private String postalCode;

    @Past(message = "Invalid date of birth")
    @NotNull(message = "Date of birth is required!")
    private LocalDate dateOfBirth;

    @Size(max = 500)
    private String biography;

    @URL(message = "Invalid URL format")
    private String profilePictureurl;


    public ParticipantDTO(String fullName, ParticipantType participantType, String email, String phoneNumber, String address, String city, String state, String country, String postalCode, LocalDate dateOfBirth, String biography, String profilePictureurl) {
        this.fullName = fullName;
        this.participantType = participantType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
        this.profilePictureurl = profilePictureurl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getProfilePictureurl() {
        return profilePictureurl;
    }

    public void setProfilePictureurl(String profilePictureurl) {
        this.profilePictureurl = profilePictureurl;
    }
}
