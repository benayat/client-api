package com.benaya.assignments.clientapi.exception;

import static com.benaya.assignments.clientapi.constants.ErrorConstants.DEFAULT_FILTER_NOT_FOUND_ERROR_MESSAGE;

public class FilterNotFoundException extends RuntimeException{
    public FilterNotFoundException() {
        super(DEFAULT_FILTER_NOT_FOUND_ERROR_MESSAGE);
    }

}
