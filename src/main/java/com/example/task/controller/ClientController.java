package com.example.task.controller;

import com.example.task.entities.Client;
import com.example.task.service.ActionsService;
import com.example.task.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ActionsService actionsService;
    private final ClientService clientService;

    public ClientController (ClientService clientServicee,
                             ActionsService actionsService){
        this.actionsService = actionsService;
        this.clientService = clientServicee;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getEmployeeById (@PathVariable("id") Long id) {
        Client client = clientService.getById(id);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }
    @GetMapping("/find/{iin}")
    public ResponseEntity<Client> getEmployeeByIin (@PathVariable("iin") Integer iin) {
        Client client = clientService.getByIin(iin);
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }
    
}
