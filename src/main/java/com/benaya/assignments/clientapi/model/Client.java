package com.benaya.assignments.clientapi.model;

import com.benaya.assignments.clientapi.validate.annotations.ValidIpV4Address;
import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import com.benaya.assignments.clientapi.validate.annotations.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document
@Builder
public class Client {
    @Indexed(unique = true)
    @ValidIsraeliId
    @Id
    private final String id;
    @Size(min = 4, max = 30, message = "Name should be between 4 and 30 characters")
    private final String name;
    @Email
    private final String email;
    @ValidPhoneNumber
    private final String phone;
    @ValidIpV4Address
    private final String ip;
}
