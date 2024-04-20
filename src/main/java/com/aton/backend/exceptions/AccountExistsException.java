package com.aton.backend.exceptions;

import static com.aton.backend.utils.Constants.ACCOUNT_EXISTS_CONFLICT;

public class AccountExistsException extends AccountException {
    public AccountExistsException() {
        super(ACCOUNT_EXISTS_CONFLICT);
    }
}
