package com.natalia.ePrescription.serviceImpl.exceptions;

import com.natalia.ePrescription.entity.Doctor;

public class DoctorAlreadyExistsException extends Exception{

    public DoctorAlreadyExistsException(Doctor doctor) {
        super("Doctor with email " + doctor.getEmail() + "already exists");
    }
}
