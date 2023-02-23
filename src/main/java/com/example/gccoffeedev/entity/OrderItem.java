package com.example.gccoffeedev.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity(name = "order_items")
public class OrderItem {
    @Id
    private long seq;
    private UUID productId;
    @Enumerated(EnumType.STRING)
    private Category category;
    private long price;
    private int quantity;

    public OrderItem(UUID productId, Category category, long price, int quantity) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;
}
