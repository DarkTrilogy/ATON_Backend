package com.aton.backend.dto.auth;

import com.aton.backend.dto.validation.ValidLogin;
import com.aton.backend.dto.validation.ValidPassword;
import com.aton.backend.utils.Constants;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @ValidLogin
    private String login;

    @ValidPassword
    private String password;

    @NotBlank(message = Constants.NICKNAME_MESSAGE)
    private String fio;
}
