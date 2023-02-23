package com.example.gccoffeedev.controller;

import com.example.gccoffeedev.entity.Category;

public record CreateProductRequest(String productName, Category category, long price, String description) {

}
