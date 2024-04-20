package com.aton.backend.service;

import com.aton.backend.dto.auth.SignInRequest;
import com.aton.backend.dto.auth.SignUpRequest;
import com.aton.backend.dto.auth.TokenResponse;
import com.aton.backend.entity.User;
import com.aton.backend.exceptions.AccountExistsException;
import com.aton.backend.exceptions.AccountNotFoundException;
import com.aton.backend.exceptions.WrongPasswordException;
import com.aton.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final SessionService sessionService;

    public TokenResponse signUp(SignUpRequest request) {
        log.info("Creating new account: " + request.getLogin());
        Optional<User> optionalUser = userRepository.findByLogin(request.getLogin());
        if (optionalUser.isPresent()) {
            throw new AccountExistsException();
        }
        return userService.createNewAccount(request);
    }

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository
                .findByLogin(request.getLogin())
                .orElseThrow(AccountNotFoundException::new);
        if (!encoder.matches(request.getPassword(), user.getHashedPassword()))
            throw new WrongPasswordException();
        return sessionService.newSession(user);
    }
}
