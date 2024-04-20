package com.aton.backend.controller.impl;

import com.aton.backend.controller.SignInController;
import com.aton.backend.dto.auth.SignInRequest;
import com.aton.backend.dto.auth.TokenResponse;
import com.aton.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignInControllerImpl implements SignInController {
    private final UserService userService;
    @Override
    public ResponseEntity<TokenResponse> signIn(SignInRequest request) {
        return ResponseEntity.ok(userService.signIn(request));
    }
}
