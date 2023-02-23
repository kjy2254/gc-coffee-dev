package com.example.gccoffeedev.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class OrderItem {
    @Id
    long seq;
    UUID productId;
    Category category;
    long price;
    int quantity;
}
