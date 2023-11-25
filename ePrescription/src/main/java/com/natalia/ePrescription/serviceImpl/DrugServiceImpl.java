package com.natalia.ePrescription.serviceImpl;

import com.natalia.ePrescription.entity.Drug;
import com.natalia.ePrescription.repository.DrugRepository;
import com.natalia.ePrescription.service.DrugService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DrugServiceImpl implements DrugService {

    public DrugServiceImpl(@Autowired DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    private final DrugRepository drugRepository;

    @Override
    public Drug save(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public List<Drug> findAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Drug findDrugById(Long drugId) {
        return drugRepository.getReferenceById(drugId);
    }
}
