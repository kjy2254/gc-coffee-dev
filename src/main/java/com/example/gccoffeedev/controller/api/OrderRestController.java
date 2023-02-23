package com.example.gccoffeedev.controller.api;

import com.example.gccoffeedev.controller.CreateOrderRequest;
import com.example.gccoffeedev.entity.Email;
import com.example.gccoffeedev.entity.Order;
import com.example.gccoffeedev.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    @Autowired
    private final Service service;

    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        return service.createOrder(
                orderRequest.email(),
                orderRequest.address(),
                orderRequest.postcode(),
                orderRequest.orderItems()
        );
    }
}
