package com.benaya.assignments.clientapi.controller;

import com.benaya.assignments.clientapi.api.ClientApi;
import com.benaya.assignments.clientapi.model.Client;
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
    @PostMapping("/add")
    public void addOrUpdateClient(@Valid @RequestBody Client client) {
        clientService.addClient(client);
    }
    @Override
    @DeleteMapping("/delete")
    public void deleteClient(@ValidIsraeliId @RequestParam String id) {
        clientService.deleteClient(id);
    }
    @Override
    @GetMapping("/all")
    public Page<Client> getAllClients(Pageable pageable) {
        return clientService.getAllClients(pageable);
    }
    @Override
    @GetMapping("/byId")
    public Client getClientById(@ValidIsraeliId @RequestParam String id) {
        return clientService.getClientById(id);
    }

    @Override
    @GetMapping("/byName")
    public Page<Client> getClientsByName(@Valid @RequestParam String name) {
        return clientService.getClientsByFullName(name);
    }
    @Override
    @GetMapping("/byFirstName")
    public Page<Client> getClientsByFirstName(@RequestParam String firstName) {
        return clientService.getClientsByFirstName(firstName);
    }
    @Override
    @GetMapping("/byLastName")
    public Page<Client> getClientsByLastName(@RequestParam String lastName) {
        return clientService.getClientsByLastName(lastName);
    }
    @Override
    @GetMapping("/byIp")
    public Page<Client> getClientsByIp(@ValidIpV4Address @RequestParam String ip) {
        return clientService.getClientsByIp(ip);
    }
    @Override
    @GetMapping("/byPhone")
    public Page<Client> getClientsByPhone(@ValidPhoneNumber @RequestParam String phone) {
        return clientService.getClientsByPhone(phone);
    }
    @Override
    @GetMapping("/byEmail")
    public Page<Client> getClientsByEmail(@Email @RequestParam String email) {
        return clientService.getClientsByEmail(email);
    }
}
