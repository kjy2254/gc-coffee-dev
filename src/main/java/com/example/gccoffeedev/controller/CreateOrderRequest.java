package com.example.gccoffeedev.controller;

import com.example.gccoffeedev.entity.OrderItem;

import java.util.List;

public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {

}