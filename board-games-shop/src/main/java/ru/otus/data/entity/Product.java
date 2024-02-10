package ru.otus.data.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.otus.data.enums.Genre;
import ru.otus.data.enums.ProductType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @ManyToOne
    private Publisher publisher;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type;
    private Long addonForGameId;
}
