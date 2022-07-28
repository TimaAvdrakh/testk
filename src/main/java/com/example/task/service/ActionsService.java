package com.example.task.service;

import com.example.task.entities.Product;
import com.example.task.repositories.ActionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ActionsService {

    private final ActionRepository actionRepository;

    public List<Product> getProductInAction(){
        LocalDate now = LocalDate.now();

        return actionRepository.getProductInAction(now);
    }
}
