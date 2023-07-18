package com.benaya.assignments.clientapi.service;

import com.benaya.assignments.clientapi.exception.ClientNotFoundException;
import com.benaya.assignments.clientapi.model.Client;
import com.benaya.assignments.clientapi.repository.ClientRepository;
import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final IpGeoLocationService ipGeoLocationService;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public void addBatchClients(List<Client> clients) {
        clientRepository.saveAll(clients);
        ipGeoLocationService.addBatchIpGeoLocations(clients.stream().map(Client::getIp).toList());
    }

    public void addClient(@Valid Client client) {
        clientRepository.save(client);
        ipGeoLocationService.addIpGeoLocation(client.getIp());
    }

    public void deleteClient(@ValidIsraeliId String id) {
        if (!clientRepository.existsById(id))
            throw new ClientNotFoundException();
        clientRepository.deleteById(id);
    }

    public Client getClientById(@ValidIsraeliId String id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }
    public List<Client> getClientsByLastName(String lastName) {
        return clientRepository.findAllByNameEndingWith(lastName);
    }

    public List<Client> getClientsByFirstName(String firstName) {
        return clientRepository.findAllByNameStartingWith(firstName);
    }

    public List<Client> getClientsByFullName(String fullName) {
        return clientRepository.findAllByName(fullName);
    }

    public List<Client> getClientsByIp(String ip) {
        return clientRepository.findAllByIp(ip);
    }

    public List<Client> getClientsByPhone(String phone) {
        return clientRepository.findAllByPhone(phone);
    }

    public List<Client> getClientsByEmail(String email) {
        return clientRepository.findAllByEmail(email);
    }
}
