package ru.otus.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.data.entity.Product;
import ru.otus.data.enums.ProductType;
import ru.otus.data.repository.ProductRepository;
import ru.otus.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public List<Product> getAllAddonsByGame(Product product) {
        if (ProductType.GAME.equals(product.getType())) {
            return productRepository.findAllProductsByAddonForGameId(product.getId());
        } else {
            throw new RuntimeException("Product is not a game");
        }
    }

    @Override
    @Transactional
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }
}