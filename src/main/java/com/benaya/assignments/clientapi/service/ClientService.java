package com.benaya.assignments.clientapi.service;

import com.benaya.assignments.clientapi.exception.ClientNotFoundException;
import com.benaya.assignments.clientapi.exception.FilterNotFoundException;
import com.benaya.assignments.clientapi.model.Client;
import com.benaya.assignments.clientapi.model.FilterType;
import com.benaya.assignments.clientapi.repository.ClientRepository;
import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final IpGeoLocationService ipGeoLocationService;

    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
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
    public Page<Client> filterClientsWithPrefix(Pageable pageable, FilterType filterField, String prefix) {
        return switch (filterField){
            case ID -> clientRepository.findAllByIdStartingWith(pageable, prefix);
            case IP -> clientRepository.findAllByIpStartingWith(pageable, prefix);
            case PHONE -> clientRepository.findAllByPhoneStartingWith(pageable, prefix);
            case EMAIL -> clientRepository.findAllByEmailStartingWith(pageable, prefix);
            case NAME -> clientRepository.findAllByNameStartingWith(pageable, prefix);
            default -> throw new FilterNotFoundException();
        };
    }
    public Page<Client> getClientsByLastName(Pageable pageable, String lastName) {
        return clientRepository.findAllByNameEndingWith(pageable, lastName);
    }

    public Page<Client> getClientsByFirstName(Pageable pageable, String firstName) {
        return clientRepository.findAllByNameStartingWith(pageable, firstName);
    }

    public Page<Client> getClientsByFullName(Pageable pageable, String fullName) {
        return clientRepository.findAllByName(pageable, fullName);
    }

    public Page<Client> getClientsByIp(Pageable pageable, String ip) {
        return clientRepository.findAllByIp(pageable, ip);
    }

    public Page<Client> getClientsByPhone(Pageable pageable, String phone) {
        return clientRepository.findAllByPhone(pageable, phone);
    }

    public Page<Client> getClientsByEmail(Pageable pageable, String email) {
        return clientRepository.findAllByEmail(pageable, email);
    }
}
