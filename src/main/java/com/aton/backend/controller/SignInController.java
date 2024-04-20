package com.aton.backend.controller;

import com.aton.backend.dto.auth.SignInRequest;
import com.aton.backend.dto.auth.TokenResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@Tag(name = "Sign In API", description = "Вход в аккаунт")
@RequestMapping("/auth/signin")
public interface SignInController {

    @Operation(summary = "Вход в аккаунт")
    @PostMapping
    ResponseEntity<TokenResponse> signIn(@Valid @RequestBody SignInRequest request);
}
