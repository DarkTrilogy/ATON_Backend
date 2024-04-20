package com.aton.backend.controller;

import com.aton.backend.dto.auth.SignUpRequest;
import com.aton.backend.dto.auth.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Tag(name = "Sign Up API", description = "Регистрация")
@RequestMapping("auth/signup")
public interface SignUpController {
    @Operation(description = "Регистрация пользователей")
    @PostMapping
    ResponseEntity<TokenResponse> signUp(@Valid @RequestBody SignUpRequest request);
}
