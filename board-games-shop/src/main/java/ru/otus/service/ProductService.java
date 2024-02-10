package ru.otus.service;

import ru.otus.data.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllAddonsByGame(Product product);
    void addNewProduct(Product product);
}
