package com.example.task.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer category_id;
    private String dame;
    private String description;
    private Integer price;

    @OneToOne(mappedBy = "product")
    private Action action;

}
