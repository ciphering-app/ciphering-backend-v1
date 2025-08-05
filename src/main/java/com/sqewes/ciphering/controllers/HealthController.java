package com.sqewes.ciphering.controllers;

import com.example.api.HealthApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi {
    @Override
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("Application is Up", HttpStatus.OK);
    }
}
