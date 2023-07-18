package com.benaya.assignments.clientapi.exception;

import static com.benaya.assignments.clientapi.constants.ErrorConstants.DEFAULT_NO_CLIENT_FOUND_ERROR_MESSAGE;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
        super(DEFAULT_NO_CLIENT_FOUND_ERROR_MESSAGE);
    }
}
