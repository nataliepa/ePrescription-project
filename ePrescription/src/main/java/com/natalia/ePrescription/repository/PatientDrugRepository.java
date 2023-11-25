package com.natalia.ePrescription.repository;

import com.natalia.ePrescription.entity.PatientDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDrugRepository extends JpaRepository<PatientDrug, Long> {
}
