package com.parZival26.crud_client_api.controller;

import com.parZival26.crud_client_api.dto.ClientCreateDTO;
import com.parZival26.crud_client_api.dto.ClientUpdateDTO;
import com.parZival26.crud_client_api.entity.Client;
import com.parZival26.crud_client_api.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return this.clientService.getClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> get(@PathVariable("id") Long id) {
        return this.clientService.getClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody ClientCreateDTO createDTO) {
        return this.clientService.createClient(createDTO);
    }

    @PatchMapping("/{id}")
    public Client update(@PathVariable("id") Long id, @Valid @RequestBody ClientUpdateDTO clientUpdateDTO) {
        return this.clientService.updateClient(clientUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.clientService.deleteClient(id);
        return String.format("Client with ID %d successfully deleted", id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
