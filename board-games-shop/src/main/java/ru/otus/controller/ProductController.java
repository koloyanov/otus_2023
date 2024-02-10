package ru.otus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.data.entity.Product;
import ru.otus.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/new-product", method = RequestMethod.POST)
    public void addNewProduct(Product product) {
        productService.addNewProduct(product);
    }

    @RequestMapping(value = "/get-all-addons", method = RequestMethod.GET)
    public List<Product> getAllAddonsForGame(Product product) {
        return productService.getAllAddonsByGame(product);
    }
}
