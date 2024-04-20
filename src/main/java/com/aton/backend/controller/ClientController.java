package com.aton.backend.controller;

import com.aton.backend.dto.user.UserChangeRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.aton.backend.utils.Constants.SUCCESS;

@Tag(name = "Client API", description = "Работа с клиентами")
@RequestMapping("/client")
public interface ClientController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/add")
    ResponseEntity<?> addToUser(@RequestBody UserChangeRequest userChangeRequest);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/delete")
    ResponseEntity<?> deleteFromUser(@RequestBody Integer clientId);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping
    ResponseEntity<?> getClientById(@RequestParam Integer clientId);
}
