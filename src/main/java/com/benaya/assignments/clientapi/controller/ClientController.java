package com.benaya.assignments.clientapi.controller;

import com.benaya.assignments.clientapi.api.ClientApi;
import com.benaya.assignments.clientapi.model.Client;
import com.benaya.assignments.clientapi.model.FilterType;
import com.benaya.assignments.clientapi.service.ClientService;
import com.benaya.assignments.clientapi.validate.annotations.ValidIpV4Address;
import com.benaya.assignments.clientapi.validate.annotations.ValidIsraeliId;
import com.benaya.assignments.clientapi.validate.annotations.ValidPhoneNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@CrossOrigin(methods = {RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.POST}, origins = "*")
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public void addOrUpdateClient(@Valid @RequestBody Client client) {
        clientService.addClient(client);
    }
    @Override
    public void deleteClient(@ValidIsraeliId @RequestParam String id) {
        clientService.deleteClient(id);
    }
    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientService.getAllClients(pageable);
    }
    @Override
    public Client getClientById(@ValidIsraeliId @RequestParam String id) {
        return clientService.getClientById(id);
    }

    @Override
    public Page<Client> getClientsByName(Pageable pageable, @Valid @RequestParam String name) {
        return clientService.getClientsByFullName(pageable, name);
    }
    @Override
    public Page<Client> getClientsByFirstName(Pageable pageable, @RequestParam String firstName) {
        return clientService.getClientsByFirstName(pageable, firstName);
    }
    @Override
    public Page<Client> getClientsByLastName(Pageable pageable, @RequestParam String lastName) {
        return clientService.getClientsByLastName(pageable, lastName);
    }
    @Override
    public Page<Client> getClientsByIp(Pageable pageable, @ValidIpV4Address @RequestParam String ip) {
        return clientService.getClientsByIp(pageable, ip);
    }
    @Override
    public Page<Client> getClientsByPhone(Pageable pageable, @ValidPhoneNumber @RequestParam String phone) {
        return clientService.getClientsByPhone(pageable, phone);
    }
    @Override
    public Page<Client> getClientsByEmail(Pageable pageable, @Email @RequestParam String email) {
        return clientService.getClientsByEmail(pageable, email);
    }
    @Override
    public Page<Client> filterClientsWithPrefix(Pageable pageable, @RequestParam String filterField, @RequestParam String prefix) {
        return clientService.filterClientsWithPrefix(pageable, FilterType.get(filterField), prefix);
    }
}
