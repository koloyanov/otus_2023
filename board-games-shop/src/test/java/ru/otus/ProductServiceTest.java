package ru.otus;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.data.entity.Product;
import ru.otus.data.enums.Genre;
import ru.otus.data.enums.ProductType;
import ru.otus.data.repository.ProductRepository;
import ru.otus.service.ProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    @Transactional
    public void getProductByIdTest() {
        String productName = "game";
        Long productId = addGameToRep(productName, 10000, Genre.EURO).getId();
        assertEquals(productName, productService.getProductById(productId).getName());
    }

    @Test
    public void getAddonsForGameTest() {
        Product product1 = addGameToRep("game01", 10000, Genre.EURO);
        Product product2 = addGameToRep("game02", 7000, Genre.DETECTIVE);

        addAddonForGameToRep("addon1" ,2000, product1);
        addAddonForGameToRep("addon2" ,3000, product1);
        addAddonForGameToRep("addon3" ,4000, product1);
        addAddonForGameToRep("addon4" ,1000, product1);
        addAddonForGameToRep("addon1", 2500, product2);

        List<Product> products = productService.getAllAddonsByGame(product1);
        assertEquals(products.size(), 4);
    }

    @Test
    public void productNotAGameException() {
        Product game = addGameToRep("game01", 10000, Genre.EURO);
        Product addon = addAddonForGameToRep("addon1" ,2000, game);
        Throwable exception = assertThrows(RuntimeException.class, () -> productService.getAllAddonsByGame(addon));
        assertEquals("Product is not a game", exception.getMessage());
    }

    private Product addGameToRep(String name, int price, Genre genre) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setGenre(genre);
        product.setType(ProductType.GAME);

        productService.addNewProduct(product);
        return product;
    }

    private Product addAddonForGameToRep(String name, int price, Product game) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setType(ProductType.ADDON);
        product.setAddonForGameId(game.getId());
        productService.addNewProduct(product);
        return product;
    }
}
