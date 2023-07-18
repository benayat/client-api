package com.benaya.assignments.clientapi.api;

import com.benaya.assignments.clientapi.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
public interface ClientApi {
    @Operation(summary = "Add or update a client")
    @ApiResponse(responseCode = "200", description = "Client added successfully",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class)) })
    void addOrUpdateClient(@RequestBody Client client);

    @Operation(summary = "Delete a client by their ID")
    @ApiResponse(responseCode = "200", description = "Client deleted successfully")
    void deleteClient(@Parameter(description = "ID of the client to be deleted") @RequestParam String id);

    @Operation(summary = "Get all clients")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getAllClients();

    @Operation(summary = "Get a client by their ID")
    @ApiResponse(responseCode = "200", description = "Fetched client successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    Client getClientById(@RequestParam String id);
    @Operation(summary = "Get clients by name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByName(@Parameter(description = "Name of the client to be fetched") @RequestParam String name);
    @Operation(summary = "Get clients by first name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByFirstName(@Parameter(description = "First name of the client to be fetched") @RequestParam String firstName);

    @Operation(summary = "Get clients by last name")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByLastName(@Parameter(description = "Last name of the client to be fetched") @RequestParam String lastName);

    @Operation(summary = "Get clients by IP address")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByIp(@Parameter(description = "IP address of the client to be fetched") @RequestParam String ip);

    @Operation(summary = "Get clients by phone number")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByPhone(@Parameter(description = "Phone number of the client to be fetched") @RequestParam String phone);

    @Operation(summary = "Get clients by email address")
    @ApiResponse(responseCode = "200", description = "Fetched clients successfully", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) })
    List<Client> getClientsByEmail(@Parameter(description = "Email address of the client to be fetched") @RequestParam String email);

}
