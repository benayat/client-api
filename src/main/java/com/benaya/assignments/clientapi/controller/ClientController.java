package com.benaya.assignments.clientapi.controller;

import com.benaya.assignments.clientapi.model.Client;
import com.benaya.assignments.clientapi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @PostMapping("/add")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }
    @GetMapping("/delete")
    public void deleteClient(@RequestParam String id) {
        clientService.deleteClient(id);
    }
    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/byName")
    public List<Client> getClientsByName(@RequestParam String name) {
        return clientService.getClientsByFullName(name);
    }
    @GetMapping("/byFirstName")
    public List<Client> getClientsByFirstName(@RequestParam String firstName) {
        return clientService.getClientsByFirstName(firstName);
    }
    @GetMapping("/byLastName")
    public List<Client> getClientsByLastName(@RequestParam String lastName) {
        return clientService.getClientsByLastName(lastName);
    }
    @GetMapping("/byIp")
    public List<Client> getClientsByIp(@RequestParam String ip) {
        return clientService.getClientsByIp(ip);
    }
    @GetMapping("/byPhone")
    public List<Client> getClientsByPhone(@RequestParam String phone) {
        return clientService.getClientsByPhone(phone);
    }
    @GetMapping("/byEmail")
    public List<Client> getClientsByEmail(@RequestParam String email) {
        return clientService.getClientsByEmail(email);
    }
}
