package com.shop.marketplace.repository;

import com.shop.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
