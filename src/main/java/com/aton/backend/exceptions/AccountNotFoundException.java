package com.aton.backend.exceptions;

import static com.aton.backend.utils.Constants.ACCOUNT_NOT_FOUND;

public class AccountNotFoundException extends AccountException {
    public AccountNotFoundException() {
        super(ACCOUNT_NOT_FOUND);
    }
}
