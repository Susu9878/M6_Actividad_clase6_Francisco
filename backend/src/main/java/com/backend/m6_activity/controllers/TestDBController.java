package com.backend.m6_activity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.m6_activity.services.FirebaseService;

@RestController
public class TestDBController {
    private final FirebaseService firebaseService;
    
    public TestDBController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("/firebase-test")
    public String testFirebase() {
        firebaseService.guardarDato();
        return "Dato enviado a Firebase";
    }
}
