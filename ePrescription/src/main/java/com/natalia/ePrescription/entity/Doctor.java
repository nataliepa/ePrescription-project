package com.natalia.ePrescription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    @NotEmpty(message = "Email may not be empty")
    @Email
    //@Size(min=7, max=50)
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password may not be empty")
    @Size(min=8, max = 20)
    private String password;

    @Column(name = "phone")
    @NotEmpty(message = "Phone number may not be empty")
    @Size(min=10, max = 20)
    private String phone;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


}
