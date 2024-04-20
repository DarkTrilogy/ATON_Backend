package com.aton.backend.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Неправильный email или пароль");
    }
}
