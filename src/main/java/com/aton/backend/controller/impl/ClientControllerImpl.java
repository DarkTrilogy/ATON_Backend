package com.aton.backend.controller.impl;

import com.aton.backend.controller.ClientController;
import com.aton.backend.dto.user.UserChangeRequest;
import com.aton.backend.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<?> addToUser(UserChangeRequest userChangeRequest) {
        return ResponseEntity.ok(clientService.addToUser(userChangeRequest));
    }

    @Override
    public ResponseEntity<?> deleteFromUser(Integer clientId) {
        return ResponseEntity.ok(clientService.deleteFromUser(clientId));
    }

    @Override
    public ResponseEntity<?> getClientById(Integer clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }
}
