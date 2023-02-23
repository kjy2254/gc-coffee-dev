package com.example.gccoffeedev.repository;

import com.example.gccoffeedev.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
