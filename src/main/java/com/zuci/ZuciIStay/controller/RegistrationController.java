package com.zuci.ZuciIStay.controller;

import com.zuci.ZuciIStay.model.Registration;
import com.zuci.ZuciIStay.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/signup")
    public Registration addDetails(@Valid @RequestBody Registration registration){
        return registrationService.addDetails(registration);
    }
    @GetMapping("/registration/{userId}")
    public List<Registration> findBookingByUserId(@PathVariable("userId") int userId){
        return registrationService.findBookingByUserId(userId);
    }
}
