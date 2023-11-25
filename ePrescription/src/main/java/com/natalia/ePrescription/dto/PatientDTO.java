package com.natalia.ePrescription.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    @NotEmpty(message = "Phone number may not be empty")
    @Size(min=10, max = 20)
    private String phone;
    private String fathersName;
    private String mothersName;
    @NotEmpty(message = "Email may not be empty")
    @Size(min=7, max=50)
    private String email;
    private String city;
    @Size(min=11, max=11)
    @Pattern(regexp = "^[0-9]+$", message = "amka must contain only numbers")
    private String amka;
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "ID must contain only letters and numbers")
    private String idCard;
    @Size(min = 5, max = 5)
    @Pattern(regexp = "^[0-9]+$", message = "PC must contain only numbers")
    private String postalCode;
    /*private String symptoms;
    private String pharmacy;
    private String doctorName;
    private String message;*/

}
