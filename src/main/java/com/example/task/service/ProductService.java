package com.example.task.service;


import com.example.task.entities.Product;
import com.example.task.exceptions.ClientNotFoundException;
import com.example.task.exceptions.ProductNotFoundException;
import com.example.task.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getByDescripton(String description){
        return productRepository.getProductsByDescription(description)
                .orElseThrow(() -> new ProductNotFoundException("Product by desc " + description + " was not found"));
    }
}
