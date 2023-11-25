package com.natalia.ePrescription.serviceImpl;

import com.natalia.ePrescription.dto.DoctorRegisterDTO;
import com.natalia.ePrescription.entity.Doctor;
import com.natalia.ePrescription.repository.DoctorRepository;
import com.natalia.ePrescription.service.DoctorService;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorAlreadyExistsException;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Override
    public Doctor login(String email, String password) throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findByEmailAndPassword(email, password);

        if(doctor != null) {
            return doctor;
        } else {
            throw new DoctorNotFoundException();
        }

    }

    @Override
    public Doctor save(DoctorRegisterDTO doctorRegisterDTO) throws DoctorAlreadyExistsException {

        Doctor doctor = new Doctor();

        doctor.setId(doctorRegisterDTO.getId());
        doctor.setEmail(doctorRegisterDTO.getEmail());
        doctor.setPassword(doctorRegisterDTO.getPassword());
        doctor.setPhone(doctorRegisterDTO.getPhone());

        if(!doctorRepository.existsByEmail(doctor.getEmail())) {
            return doctorRepository.save(doctor);
        } else {
            throw new DoctorAlreadyExistsException(doctor);
        }
    }
}
