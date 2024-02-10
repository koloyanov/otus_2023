package ru.otus.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JoinColumn
    @Column(nullable = false)
    private Shop shop;
    @JoinColumn
    @Column(nullable = false)
    private Product product;
    private Integer productsStock;
}
