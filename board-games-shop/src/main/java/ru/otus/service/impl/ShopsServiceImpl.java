package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.data.entity.Product;
import ru.otus.data.entity.Shop;
import ru.otus.data.entity.Stock;
import ru.otus.data.repository.ShopRepository;
import ru.otus.data.repository.StockRepository;
import ru.otus.service.ProductService;
import ru.otus.service.ShopsService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopsServiceImpl implements ShopsService {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductService productService;

    @Override
    public void addNewShop(String address) {
        if (shopRepository.findFirstByAddress(address).isEmpty()) {
            shopRepository.save(new Shop(address));
        } else {
            throw new RuntimeException("Shop with this address is already exists");
        }
    }

    @Override
    public void addNewProductsToShop(Long shopId, Long productId, Integer numberOfProducts) {
        Optional<Stock> stockOpt = stockRepository.findFirstByShopIdAndProductId(shopId, productId);
        if (stockOpt.isPresent()) {
            stockOpt.get().setProductsStock(stockOpt.get().getProductsStock() + numberOfProducts);
            stockRepository.save(stockOpt.get());
        } else {
            Stock stock = new Stock();

            Product product = productService.getProductById(productId);
            if (product == null) throw new RuntimeException("Product with this id is not exists");

            stock.setProduct(product);
            stock.setShop(shopRepository.getReferenceById(shopId));
            stock.setProductsStock(numberOfProducts);
            stockRepository.save(stock);
        }
    }

    @Override
    public Product getProductFromShop(Long shopId, Long productId, Integer numberOfProducts) {
        Optional<Stock> stockOpt = stockRepository.findFirstByShopIdAndProductId(shopId, productId);
        if (stockOpt.isEmpty() || stockOpt.get().getProductsStock() < numberOfProducts) {
            throw new RuntimeException("This shop doesn\'t have so much products of this type");
        } else {
            stockOpt.get().setProductsStock(stockOpt.get().getProductsStock() - numberOfProducts);
            stockRepository.save(stockOpt.get());
            return productService.getProductById(productId);
        }
    }

    @Override
    public Shop getShopById(Long shopId) {
        Optional<Shop> shopOpt = Optional.ofNullable(shopRepository.getReferenceById(shopId));
        if (!shopOpt.isPresent()) throw new RuntimeException("Shop with this id doesn\'t exist");
        return shopOpt.get();
    }

}
