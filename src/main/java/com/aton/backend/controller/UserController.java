package com.aton.backend.controller;

import com.aton.backend.dto.user.UserChangeRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.aton.backend.utils.Constants.SUCCESS;

@Tag(name = "User API", description = "Работа с пользователем")
@RequestMapping("/user")
public interface UserController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/all")
    ResponseEntity<?> getAllUsers();

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping
    ResponseEntity<?> getUserByLogin(@RequestParam String login);
}
