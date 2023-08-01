package com.benaya.assignments.clientapi.api;

import com.benaya.assignments.clientapi.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public interface ClientApi {
    @Operation(summary = "Add or update a client")
    @ApiResponse(responseCode = "200", description = "Client added successfully",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class)) })
    @PostMapping("/add")
    void addOrUpdateClient(@RequestBody Client client);

    @Operation(summary = "Delete a client by their ID")
    @ApiResponse(responseCode = "200", description = "Client deleted successfully")
    @DeleteMapping("/delete")
    void deleteClient(@Parameter(description = "ID of the client to be deleted") @RequestParam String id);

    @Operation(summary = "Get all clients")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/all")
    Page<Client> getAllClients(Pageable pageable);

    @Operation(summary = "Get a client by their ID")
    @ApiResponse(responseCode = "200", description = "Fetched client successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byId")
    Client getClientById(@RequestParam String id);
    @Operation(summary = "Get clients by name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byName")
    Page<Client> getClientsByName(Pageable pageable, @Parameter(description = "Name of the client to be fetched") @RequestParam String name);
    @Operation(summary = "Get clients by first name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byFirstName")
    Page<Client> getClientsByFirstName(Pageable pageable, @Parameter(description = "First name of the client to be fetched") @RequestParam String firstName);

    @Operation(summary = "Get clients by last name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byLastName")
    Page<Client> getClientsByLastName(Pageable pageable, @Parameter(description = "Last name of the client to be fetched") @RequestParam String lastName);

    @Operation(summary = "Get clients by IP address")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byIp")
    Page<Client> getClientsByIp(Pageable pageable, @Parameter(description = "IP address of the client to be fetched") @RequestParam String ip);

    @Operation(summary = "Get clients by phone number")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byPhone")
    Page<Client> getClientsByPhone(Pageable pageable, @Parameter(description = "Phone number of the client to be fetched") @RequestParam String phone);

    @Operation(summary = "Get clients by email address")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byEmail")
    Page<Client> getClientsByEmail( Pageable pageable, @Parameter(description = "Email address of the client to be fetched") @RequestParam String email);

    @Operation(summary = "filter clients by prefix of selected field")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    @GetMapping("/byPrefix")
    Page<Client> filterClientsWithPrefix(Pageable pageable, @Parameter(description = "the field to filter by") @RequestParam String filterField, @Parameter(description = "the string prefix") @RequestParam String prefix);
}
