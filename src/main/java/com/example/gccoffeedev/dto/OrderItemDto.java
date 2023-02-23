package com.example.gccoffeedev.dto;

import com.example.gccoffeedev.entity.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class OrderItemDto {
    private UUID productId;
    @Enumerated(EnumType.STRING)
    private Category category;
    private long price;
    private int quantity;

    public OrderItemDto(UUID productId, Category category, long price, int quantity) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}
