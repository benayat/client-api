package com.benaya.assignments.clientapi.model;

import com.benaya.assignments.clientapi.validate.annotations.ValidIpV4Address;
import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import com.benaya.assignments.clientapi.validate.annotations.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document
public class Client {
    @Indexed(unique = true)
    @ValidIsraeliId
    @Id
    private final String id;
    @Min(value = 4, message = "Name should have at least 4 characters")
    @Max(value = 30, message = "Name should have at most 30 characters")
    private final String name;
    @Email
    private final String email;
    @ValidPhoneNumber
    private final String phone;
    @ValidIpV4Address
    private final String ip;
}
