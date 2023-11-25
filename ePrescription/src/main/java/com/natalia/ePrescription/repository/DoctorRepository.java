package com.natalia.ePrescription.repository;

import com.natalia.ePrescription.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
