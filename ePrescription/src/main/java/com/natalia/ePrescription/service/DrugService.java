package com.natalia.ePrescription.service;

import com.natalia.ePrescription.entity.Drug;

import java.util.List;

public interface DrugService {
    Drug save(Drug drug);
    List<Drug> findAllDrugs();
    Drug findDrugById(Long drugId);
}
