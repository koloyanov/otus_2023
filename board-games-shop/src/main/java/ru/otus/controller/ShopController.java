package ru.otus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.data.entity.Product;
import ru.otus.service.ShopsService;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopsService shopsService;

    @RequestMapping(value = "/new-shop", method = RequestMethod.POST)
    public void addNewShop(String address) {
        shopsService.addNewShop(address);
    }

    @RequestMapping(value = "/get-products", method = RequestMethod.GET)
    public Product getProducts(Long shopId, Long productId, Integer numberOfProducts) {
        return shopsService.getProductFromShop(shopId, productId, numberOfProducts);
    }

}
