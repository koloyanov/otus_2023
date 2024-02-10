package ru.otus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.data.entity.Product;
import ru.otus.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/new-product", method = RequestMethod.POST)
    public void addNewProduct(String address) {
        productService.addNewProduct(new Product());
    }
}
