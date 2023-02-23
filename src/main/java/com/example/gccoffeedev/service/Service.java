package com.example.gccoffeedev.service;

import com.example.gccoffeedev.dto.OrderItemDto;
import com.example.gccoffeedev.entity.*;
import com.example.gccoffeedev.repository.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


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

        Order save = orderRepository.save(order);

        orderItems.forEach(v -> {
            v.setOrder(order);
            v.setCreatedAt(LocalDateTime.now());
            v.setUpdatedAt(LocalDateTime.now());
            orderItemRepository.save(v);
        });

        return save;
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
