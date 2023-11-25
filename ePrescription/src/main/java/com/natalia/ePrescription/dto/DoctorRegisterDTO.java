package com.natalia.ePrescription.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRegisterDTO {

    private Long id;

    @NotEmpty(message = "Please enter your email")
    @Email
    //@Size(min=7, max=50)
    private String email;

    @NotEmpty(message = "Please enter your password")
    @Size(min=8, max = 20, message = "Your password length must be between 8 and 20")
    private String password;

    @NotEmpty(message = "Please enter your password")
    @Pattern(regexp = "^[0-9]+$", message = "Phone must contain only numbers")
    @Size(min=10, max = 10, message = "Phone must contain 10 numbers")
    private String phone;
}
