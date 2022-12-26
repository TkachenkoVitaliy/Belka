package ru.vtkachenko.belka_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MainController {

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity testMapping() {

        return ResponseEntity.ok("HELLO");
    }
}
