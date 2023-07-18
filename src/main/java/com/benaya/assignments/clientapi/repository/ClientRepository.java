package com.benaya.assignments.clientapi.repository;

import com.benaya.assignments.clientapi.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {
    Page<Client> findAllByName(String fullName);
    Page<Client> findAllByNameEndingWith(String lastName);
    Page<Client> findAllByNameStartingWith(String firstName);
    Page<Client> findAllByIp(String ip);
    Page<Client> findAllByPhone(String phone);
    Page<Client> findAllByEmail(String email);


}
