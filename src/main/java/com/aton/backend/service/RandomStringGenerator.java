package com.aton.backend.service;

import java.security.SecureRandom;
import java.util.Random;

import static com.aton.backend.utils.Constants.CHARS;

public class RandomStringGenerator {
    public static String generateRandomString(int length) {
        String characters = CHARS;
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
