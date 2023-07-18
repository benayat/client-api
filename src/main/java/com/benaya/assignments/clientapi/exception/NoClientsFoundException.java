package com.benaya.assignments.clientapi.exception;

import static com.benaya.assignments.clientapi.constants.ErrorConstants.DEFAULT_NO_CLIENTS_FOUND_ERROR_MESSAGE;
public class NoClientsFoundException extends RuntimeException {
    public NoClientsFoundException() {
        super(DEFAULT_NO_CLIENTS_FOUND_ERROR_MESSAGE);
    }
}
