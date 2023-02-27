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
public class OrderController {

    @Autowired
    private final Service service;

    @GetMapping("/orders")
    public String ordersPage(Model model) {
        var orders = service.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list";
    }

}