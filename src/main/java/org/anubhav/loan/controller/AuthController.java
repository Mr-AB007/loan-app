package org.anubhav.loan.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.anubhav.loan.dto.AuthResponse;
import org.anubhav.loan.dto.LoginRequest;
import org.anubhav.loan.dto.RegisterRequest;
import org.anubhav.loan.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
} 