package com.aton.backend.service;

import com.aton.backend.dto.auth.SignInRequest;
import com.aton.backend.dto.auth.SignUpRequest;
import com.aton.backend.dto.auth.TokenResponse;
import com.aton.backend.dto.user.UserChangeRequest;
import com.aton.backend.dto.user.UserResponse;
import com.aton.backend.entity.Client;
import com.aton.backend.entity.User;
import com.aton.backend.entity.UserRole;
import com.aton.backend.repository.ClientRepository;
import com.aton.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final SessionService sessionService;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public TokenResponse createNewAccount(SignUpRequest request) {
        User toSave = new User()
                .setLogin(request.getLogin())
                .setFio(request.getFio())
                .setHashedPassword(encoder.encode(request.getPassword()))
                .setUserRole(UserRole.ROLE_USER);
        toSave = userRepository.save(toSave);
        return sessionService.newSession(toSave);
    }

    @Transactional
    public UserResponse getUserByLogin(String login) {
        User user = userRepository.findByLogin(login).orElseThrow();
        return new UserResponse()
                .setId(user.getUserId())
                .setLogin(user.getLogin())
                .setFio(user.getFio())
                .setClients(user.getClients());
    }

    @Transactional
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse()
                        .setId(user.getUserId())
                        .setLogin(user.getLogin())
                        .setFio(user.getFio()))
                .toList();
    }

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        if (encoder.matches(request.getPassword(), user.getHashedPassword())) {
            return sessionService.newSession(user);
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}
