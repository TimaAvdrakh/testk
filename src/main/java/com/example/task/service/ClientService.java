package com.example.task.service;

import com.example.task.entities.Client;
import com.example.task.exceptions.ClientNotFoundException;
import com.example.task.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client getByIin(int iin) {
        return clientRepository.findClientByIin(iin)
                .orElseThrow(() -> new ClientNotFoundException("Client by id " + iin + " was not found"));


    }
    public Client getById(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client by id " + id + " was not found"));
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public String deleteClientById(long id) {
        clientRepository.deleteById(id);
        return "Client got deleted";
    }
}
