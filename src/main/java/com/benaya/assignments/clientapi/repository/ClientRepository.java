package com.benaya.assignments.clientapi.repository;

import com.benaya.assignments.clientapi.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findAllByName(String fullName);
    List<Client> findAllByNameEndingWith(String lastName);
    List<Client> findAllByNameStartingWith(String firstName);
    List<Client> findAllByIp(String ip);
    List<Client> findAllByPhone(String phone);
    List<Client> findAllByEmail(String email);


}
