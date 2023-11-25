package com.natalia.ePrescription.repository;

import com.natalia.ePrescription.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    //void deletePatientByAmka(Long amka);
}
