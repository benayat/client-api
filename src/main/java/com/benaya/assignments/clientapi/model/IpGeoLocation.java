package com.benaya.assignments.clientapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ipGeoLocation")
@Getter
@Setter
@AllArgsConstructor
public class IpGeoLocation {
    @Id
    @Indexed(unique = true)
    @JsonProperty("query")
    private final String ip;
    private final String city;
    private final String country;
}
