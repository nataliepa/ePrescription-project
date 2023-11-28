package com.natalia.ePrescription.controller;


import com.natalia.ePrescription.dto.DoctorLoginDTO;
import com.natalia.ePrescription.dto.DoctorRegisterDTO;
import com.natalia.ePrescription.entity.Doctor;
import com.natalia.ePrescription.service.DoctorService;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorAlreadyExistsException;
import com.natalia.ePrescription.serviceImpl.exceptions.DoctorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class DoctorController {

    @Autowired
    //@Qualifier("doctorServiceImpl2")
    DoctorService doctorService;

    // Constructor level Dependency Injection
    /*public DoctorController(@Autowired DoctorService doctorService) {
        this.doctorService = doctorService;
    }*/

    // Setter level Dependency Injection
    /*@Autowired
    public void setDoctorService( DoctorService doctorService) {
        this.doctorService = doctorService;
    }*/

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("doctorLogin");
        mav.addObject("doctorLoginDTO", new DoctorLoginDTO());

        return mav;
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("doctorLoginDTO") DoctorLoginDTO doctorLoginDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "doctorLogin";
        }
        try {
            Doctor authDoctor = doctorService.login(doctorLoginDto.getEmail(), doctorLoginDto.getPassword());
            return "redirect:/allPatients";
        } catch (DoctorNotFoundException e) {
            model.addAttribute("notFound", true);
        }
        return "doctorLogin";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("doctorRegistration");
        mav.addObject("doctorRegister", new DoctorRegisterDTO());

        return mav;
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("doctorRegister") DoctorRegisterDTO doctorRegisterDTO, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "doctorRegistration";
        }

        try {
            Doctor saveDoctor = doctorService.save(doctorRegisterDTO);
            return "redirect:/login";
        } catch (DoctorAlreadyExistsException e) {
            model.addAttribute("alreadyExists", true);
        }
        return "doctorRegistration";
    }
}
