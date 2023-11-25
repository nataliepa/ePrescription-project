package com.natalia.ePrescription.service;

import com.natalia.ePrescription.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> findAllPatients();
    Patient findPatientById(Long patientId);
    void deletePatientById(Long patientId);
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
