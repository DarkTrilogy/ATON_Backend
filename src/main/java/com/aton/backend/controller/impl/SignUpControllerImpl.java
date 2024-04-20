package com.aton.backend.controller.impl;

import com.aton.backend.controller.SignUpController;
import com.aton.backend.dto.auth.SignUpRequest;
import com.aton.backend.dto.auth.TokenResponse;
import com.aton.backend.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpControllerImpl implements SignUpController {
    private final SignService service;

    @Override
    public ResponseEntity<TokenResponse> signUp(SignUpRequest request) {
        return ResponseEntity.ok(service.signUp(request));
    }
}
