package com.benaya.assignments.clientapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum FilterType {
    ID("ID"),
    IP("IP"),
    NAME("NAME"),
    EMAIL("EMAIL"),
    PHONE("PHONE"),
    CITY("CITY"),
    COUNTRY("COUNTRY");

    private final String value;
    private static final Map<String, FilterType> lookup = new HashMap<>();

    static {
        for (FilterType status : FilterType.values()) {
            lookup.put(status.getValue(), status);
        }
    }

    public static FilterType get(String value) {
        return lookup.get(value.toUpperCase());
    }
}
