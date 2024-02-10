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
    protected Long id;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected Integer price;
    @ManyToOne
    protected Publisher publisher;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type;
    private Long addonForGameId;
}
