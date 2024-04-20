package com.aton.backend.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Неправильный email или пароль");
    }
}