package com.natalia.ePrescription.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLoginDTO {
    @NotEmpty(message = "Please enter your email")
    @Email
    //@Size(min=7, max=50)
    private String email;

    @NotEmpty(message = "Please enter your password")
    @Size(min=8, max = 20, message = "Password size must be between 8 and 20")
    private String password;
}
