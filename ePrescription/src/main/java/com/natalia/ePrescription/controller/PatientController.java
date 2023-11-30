package com.natalia.ePrescription.controller;

import com.natalia.ePrescription.entity.Drug;
import com.natalia.ePrescription.entity.PatientDrug;
import org.springframework.ui.Model;
import com.natalia.ePrescription.entity.Patient;
import com.natalia.ePrescription.service.DrugService;
import com.natalia.ePrescription.service.PatientDrugService;
import com.natalia.ePrescription.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    private final PatientService patientService;
    private final DrugService drugService;
    private final PatientDrugService patientDrugService;

    public PatientController(@Autowired PatientService patientService,
                             @Autowired DrugService drugService,
                             @Autowired PatientDrugService patientDrugService) {
        this.patientService = patientService;
        this.drugService = drugService;
        this.patientDrugService = patientDrugService;
    }

    @GetMapping("/allPatients")
    public String getAllPatients(Model model) {
        List<Patient> patientList = patientService.findAllPatients();
        
        model.addAttribute("patientList", patientList);
        model.addAttribute("patientAMKA", "");
                
        return "patients";
    }

    @GetMapping("/allPatients/{amka}")
    public String getPatientByAMKA(@PathVariable("amka") String patientAMKA, Model model) {

        List<Patient> patientList = patientService.findPatientByAmka(patientAMKA);

        model.addAttribute("patientList", patientList);
        model.addAttribute("patientAMKA", patientAMKA);

        /*ModelAndView mav = new ModelAndView("patient");
        mav.addObject("patient", patient);
        mav.addObject("notFound", patient == null ? "true" : "false");*/

        return "patientsTable";
    }



    //prescribe
    @GetMapping("/prescribeDrugs/{id}")
    public ModelAndView prescribeDrugs(@PathVariable("id") String patientId) {
        ModelAndView mav = new ModelAndView("patientFormEdit");
        Long pId = Long.parseLong(patientId);

        Patient formPatient = patientService.findPatientById(pId);

        mav.addObject("patient", formPatient);
        mav.addObject("drugs", drugService.findAllDrugs());

        return mav;
    }

    @PostMapping("/prescribeDrugs/patient/{id}")
    public String prescribePatientDrugs(@PathVariable("id") String id, Patient patient, @ModelAttribute("drugs") Long drugId) {

        Long pId = Long.parseLong(id);

        Patient updatedPatient = patientService.findPatientById(pId);
        Drug drug = drugService.findDrugById(drugId);

        // patient needs to be updated since e.g. symptoms are inserted by doctor
        updatedPatient.setEmail(updatedPatient.getEmail());
        updatedPatient.setPhone(patient.getPhone());
        updatedPatient.setCity(patient.getCity());
        updatedPatient.setSymptoms(patient.getSymptoms());
        updatedPatient.setPharmacy(patient.getPharmacy());
        updatedPatient.setDoctorName(patient.getDoctorName());
        updatedPatient.setMessage(patient.getMessage());

        PatientDrug patientDrug = new PatientDrug(patient, drug, new Date());

        patientDrugService.savePatientDrug(patientDrug);
        updatedPatient.getPatientDrugSet().add(patientDrug);
        patientService.updatePatient(updatedPatient);

        return "redirect: /allPatients";

    }

    @GetMapping("/newPatient")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("patientForm");
        mav.addObject("patient", new Patient());
        mav.addObject("drugs", drugService.findAllDrugs());

        return mav;
    }


    @PostMapping
    public String createPatient(Patient patient) {
        patientService.savePatient(patient);

        return "redirect:/allPatients";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable("id") String patientId) {
        Long pid = Long.parseLong(patientId);

        Patient deletePatient = patientService.findPatientById(pid);
        patientService.deletePatient(deletePatient);

        return "redirect:/allPatients";
    }

    @GetMapping("/editPatient/{id}")
    public ModelAndView editPatient(@PathVariable("id") String patientId) {
        ModelAndView mav = new ModelAndView("patientForm2Update");

        Long pid = Long.parseLong(patientId);

        Patient formPatient = patientService.findPatientById(pid);
        mav.addObject("patient", formPatient);

        return mav;
    }


    @PostMapping("/updatePatient/Patient/{id}")
    public String updatePatient(Patient patient, @PathVariable("id") String patientId) {
        Long pid = Long.parseLong(patientId);

        Patient updatePatient = patientService.findPatientById(pid);
        updatePatient = patient;
        updatePatient.setMessage(patient.getMessage());
        patientService.updatePatient(updatePatient);

        return "redirect:/allPatients";
    }
}
