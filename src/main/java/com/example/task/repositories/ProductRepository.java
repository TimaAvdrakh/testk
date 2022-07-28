package com.example.task.repositories;

import com.example.task.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product> {
    @Query(value = "SELECT * from Product as p where p.description = ?1 limit 1",nativeQuery = true)
    Optional<Product> getProductsByDescription(String desc);
}