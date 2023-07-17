package com.benaya.assignments.clientapi.exception;

import static com.benaya.assignments.clientapi.constants.ErrorConstants.IP_GEO_LOCATION_NOT_FOUND_ERROR_MESSAGE;

public class IpGeoLocationNotFoundException extends RuntimeException{
    public IpGeoLocationNotFoundException() {
        super(IP_GEO_LOCATION_NOT_FOUND_ERROR_MESSAGE);
    }
}
