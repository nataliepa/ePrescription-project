package com.natalia.ePrescription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private String dateOfBirth;

    @Column(name = "phone")
    @NotEmpty(message = "Phone number may not be empty")
    @Size(min=10, max = 20)
    private String phone;

    @Column(name = "fathers_name")
    private String fathersName;

    @Column(name = "mothers_name")
    private String mothersName;

    @Column(name = "email")
    @NotEmpty(message = "Email may not be empty")
    @Size(min=7, max=50)
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "amka")
    @Size(min=11, max=11)
    @Pattern(regexp = "^[0-9]+$", message = "amka must contain only numbers")
    private String amka;

    @Column(name = "id_card")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "ID must contain only letters and numbers")
    private String idCard;

    @Column(name = "postal_code")
    @Size(min = 5, max = 5)
    @Pattern(regexp = "^[0-9]+$", message = "PC must contain only numbers")
    private String postalCode;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "pharmacy")
    private String pharmacy;

    @Column(name = "doctorName")
    private String doctorName;

    @Column(name = "message")
    private String message;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<PatientDrug> patientDrugSet;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", amka='" + amka + '\'' +
                ", idCard='" + idCard + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", pharmacy='" + pharmacy + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", message='" + message + '\'' +
                ", patientDrugSet=" + patientDrugSet +
                '}';
    }
}
