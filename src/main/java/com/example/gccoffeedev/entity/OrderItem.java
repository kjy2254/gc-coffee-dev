package com.example.gccoffeedev.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "order_items")
public class OrderItem {
    @Id
    private long seq;
    private UUID productId;
    @Enumerated(EnumType.STRING)
    private Category category;
    private long price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;
}
