package com.cursor.mopla.exception;

import org.springframework.security.core.AuthenticationException;

public class WrongCredentialException extends AuthenticationException {

    public WrongCredentialException(String msg) {
        super(msg);
    }

}
