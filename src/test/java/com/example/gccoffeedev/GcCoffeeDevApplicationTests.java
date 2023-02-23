package com.example.gccoffeedev;

import com.example.gccoffeedev.entity.Product;
import com.example.gccoffeedev.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class GcCoffeeDevApplicationTests {

    @Autowired
    Service service;

    @Test
    void test() {
        List<Product> allProducts = service.getAllProducts();
        log.info("Result: {}", allProducts.get(0).getProductName());
    }
}
