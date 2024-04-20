package com.aton.backend.dto.user;

import com.aton.backend.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String login;
    private String fio;
    private List<Client> clients;
}
