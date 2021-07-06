package com.shop.marketplace.repository;

import com.shop.marketplace.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
