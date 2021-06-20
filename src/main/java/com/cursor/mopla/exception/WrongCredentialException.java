package com.cursor.mopla.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class WrongCredentialException extends AuthenticationException {

    private HttpStatus httpStatus;

    public WrongCredentialException(String msg) {
        super(msg);
    }

    public WrongCredentialException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

}
