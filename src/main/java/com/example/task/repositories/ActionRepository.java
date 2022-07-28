package com.example.task.repositories;

import com.example.task.entities.Action;
import com.example.task.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    @Query("select a.product from Action as a join fetch Product as p where a.beginDate >= :date and a.endDate <=:date ")
    List<Product> getProductInAction(@Param("date") LocalDate date);
}