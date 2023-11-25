package com.natalia.ePrescription.service;

import com.natalia.ePrescription.dto.DoctorRegisterDTO;
import com.natalia.ePrescription.entity.Doctor;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorAlreadyExistsException;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorNotFoundException;

public interface DoctorService {
    Doctor login(String email, String password) throws DoctorNotFoundException;
    Doctor save(DoctorRegisterDTO doctorRegisterDTO) throws DoctorAlreadyExistsException;
}
