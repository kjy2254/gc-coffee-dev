package com.example.gccoffeedev.service;

import com.example.gccoffeedev.dto.OrderItemDto;
import com.example.gccoffeedev.entity.*;
import com.example.gccoffeedev.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final ProductRepository productRepository;


    public Order createOrder(String email, String address, String postcode, List<OrderItem> orderItems) {


        Order order = new Order(
                UUID.randomUUID(),
                email,
                address,
                postcode,
                orderItems,
                OrderStatus.ACCEPTED,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return orderRepository.save(order);
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    public Product createProduct(String productName, Category category, long price) {
//        var product = new Product(UUID.randomUUID(), productName, category, price);
//        return productRepository.save(product);
//    }

    public Product createProduct(String productName, Category category, long price, String description) {
        var product = new Product(UUID.randomUUID(), productName, category, price, description);
        return productRepository.save(product);
    }
}
