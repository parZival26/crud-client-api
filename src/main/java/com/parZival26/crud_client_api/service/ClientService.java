package com.parZival26.crud_client_api.service;

import com.parZival26.crud_client_api.dto.ClientCreateDTO;
import com.parZival26.crud_client_api.dto.ClientUpdateDTO;
import com.parZival26.crud_client_api.entity.Client;
import com.parZival26.crud_client_api.exception.ClientNotFoundException;
import com.parZival26.crud_client_api.exception.EmailAlreadyExistsException;
import com.parZival26.crud_client_api.mapper.ClientMapper;
import com.parZival26.crud_client_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return this.clientRepository.findById(id);
    }

    public Client createClient(ClientCreateDTO createDTO) {
        if (clientRepository.existsByEmail(createDTO.getEmail())) {
            throw new EmailAlreadyExistsException(createDTO.getEmail());
        }
        Client client = clientMapper.toEntity(createDTO);
        return clientRepository.save(client);
    }

    public Client updateClient(ClientUpdateDTO client, Long id) {
        //update client
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        //check if email already exists
        if (!client.getEmail().equals(existingClient.getEmail()) && clientRepository.existsByEmail(client.getEmail())) {
            throw new EmailAlreadyExistsException(client.getEmail());
        }
        clientMapper.updateClientFromDTO(client, existingClient);
        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        this.clientRepository.deleteById(id);
    }


}
