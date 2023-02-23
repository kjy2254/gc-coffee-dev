package com.example.gccoffeedev.repository;

import com.example.gccoffeedev.entity.Category;
import com.example.gccoffeedev.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByCategory(Category category);
}
