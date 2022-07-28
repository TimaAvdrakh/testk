package com.example.task.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;

    @OneToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
