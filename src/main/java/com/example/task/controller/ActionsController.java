package com.example.task.controller;

import com.example.task.entities.Client;
import com.example.task.entities.Product;
import com.example.task.service.ActionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionsController {

    private final ActionsService actionsService;

    public ActionsController (ActionsService service){
        this.actionsService = service;
    }

    @GetMapping("/product-with-action/")
    public ResponseEntity<List<Product>> getActionProducts () {
        return new ResponseEntity<>(actionsService.getProductInAction(), HttpStatus.ACCEPTED);
    }
}
