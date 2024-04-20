package com.aton.backend.controller.impl;

import com.aton.backend.controller.UserController;
import com.aton.backend.dto.user.UserChangeRequest;
import com.aton.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<?> getUserByLogin(String login) {
        return ResponseEntity.ok(userService.getUserByLogin(login));
    }
}
