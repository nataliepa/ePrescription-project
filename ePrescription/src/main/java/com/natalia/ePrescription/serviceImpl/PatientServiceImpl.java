package com.natalia.ePrescription.serviceImpl;

import com.natalia.ePrescription.entity.Patient;
import com.natalia.ePrescription.repository.PatientRepository;
import com.natalia.ePrescription.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    /*public PatientServiceImpl(@Autowired PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }*/

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(Long patientId) {
        return patientRepository.getReferenceById(patientId);
    }

    @Override
    public void deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public List<Patient> findPatientByAmka(String amka) {
        return patientRepository.findByAmkaContains(amka);
    }
}
