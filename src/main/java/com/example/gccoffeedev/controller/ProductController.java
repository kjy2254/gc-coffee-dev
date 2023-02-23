package com.example.gccoffeedev.controller;

import com.example.gccoffeedev.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final Service service;

    @GetMapping("/products")
    public String productsPage(Model model) {
        var products = service.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/new-product")
    public String newProductPage(Model model) {
        var products = service.getAllProducts();
        model.addAttribute("products", products);
        return "new-product";
    }

    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest) {
        service.createProduct(
                createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.description()
        );
        return "redirect:/products";
    }

}