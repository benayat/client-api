package com.benaya.assignments.clientapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ipGeoLocation")
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class IpGeoLocation  {
    @Id
    @Indexed(unique = true)
    @JsonProperty("query")
    private final String ip;
    @JsonProperty("city")
    private final String city;
    @JsonProperty("country")
    private final String country;
}
