package com.example.gccoffeedev.controller.api;

import com.example.gccoffeedev.entity.Category;
import com.example.gccoffeedev.entity.Product;
import com.example.gccoffeedev.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ProductRestController {

    @Autowired
    private final Service service;

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        return category
                .map(service::getProductsByCategory)
                .orElse(service.getAllProducts());
    }
}
