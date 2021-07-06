package com.shop.marketplace.repository;

import com.shop.marketplace.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
