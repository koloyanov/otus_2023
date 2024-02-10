package ru.otus.service;

import ru.otus.data.entity.Product;
import ru.otus.data.entity.Shop;

public interface ShopsService {
    void addNewShop(String address);
    Shop getShopById(Long shopId);
    void addNewProductsToShop(Long shopId, Long productId, Integer numberOfProducts);
    Product getProductFromShop(Long shopId, Long productId, Integer numberOfProducts);

}
