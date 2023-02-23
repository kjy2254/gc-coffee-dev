package com.example.gccoffeedev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

//@NoArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long seq;
    private UUID productId;
    @Enumerated(EnumType.STRING)
    private Category category;
    private long price;
    private int quantity;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setCategory(Category category) {
        this.category = category;
        updatedAt = LocalDateTime.now();
    }

    public void setPrice(long price) {
        this.price = price;
        updatedAt = LocalDateTime.now();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updatedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

}
