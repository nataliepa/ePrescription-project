package com.natalia.ePrescription.controller;

import com.natalia.ePrescription.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DrugController {

    private final DrugService drugService;

    public DrugController(@Autowired DrugService drugService) {
        this.drugService = drugService;
    }

}
