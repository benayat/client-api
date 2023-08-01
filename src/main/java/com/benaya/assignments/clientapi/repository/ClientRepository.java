package com.benaya.assignments.clientapi.repository;

import com.benaya.assignments.clientapi.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ClientRepository extends MongoRepository<Client, String> {
    Page<Client> findAllByIdStartingWith(Pageable pageable, String id);
    Page<Client> findAllByName(Pageable pageable, String fullName);
    Page<Client> findAllByNameEndingWith(Pageable pageable, String lastName);
    Page<Client> findAllByNameStartingWith(Pageable pageable, String firstName);
    Page<Client> findAllByIp(Pageable pageable, String ip);
    Page<Client> findAllByIpStartingWith(Pageable pageable, String ip);
    Page<Client> findAllByPhone(Pageable pageable, String phone);
    Page<Client> findAllByPhoneStartingWith(Pageable pageable, String phone);
    Page<Client> findAllByEmail(Pageable pageable, String email);
    Page<Client> findAllByEmailStartingWith(Pageable pageable, String email);


    List<Client> findAllByIdStartingWith(String id);
}
