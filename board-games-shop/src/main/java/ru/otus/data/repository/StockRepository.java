package ru.otus.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.data.entity.Product;
import ru.otus.data.entity.Shop;
import ru.otus.data.entity.Stock;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findFirstByShopIdAndProductId(Long shopId, Long productId);
}