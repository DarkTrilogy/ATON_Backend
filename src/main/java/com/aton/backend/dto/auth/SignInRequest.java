package com.aton.backend.dto.auth;

import com.aton.backend.dto.validation.ValidLogin;
import com.aton.backend.dto.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    @ValidLogin
    private String login;

    @ValidPassword
    private String password;
}

