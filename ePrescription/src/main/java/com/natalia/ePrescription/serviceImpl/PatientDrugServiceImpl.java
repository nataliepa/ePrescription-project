package com.natalia.ePrescription.serviceImpl;

import com.natalia.ePrescription.entity.PatientDrug;
import com.natalia.ePrescription.repository.PatientDrugRepository;
import com.natalia.ePrescription.service.PatientDrugService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientDrugServiceImpl implements PatientDrugService {

    private final PatientDrugRepository patientDrugRepository;

    public PatientDrugServiceImpl(@Autowired PatientDrugRepository patientDrugRepository) {
        this.patientDrugRepository = patientDrugRepository;
    }

    @Override
    public PatientDrug savePatientDrug(PatientDrug patientDrug) {
        return patientDrugRepository.save(patientDrug);
    }
}
