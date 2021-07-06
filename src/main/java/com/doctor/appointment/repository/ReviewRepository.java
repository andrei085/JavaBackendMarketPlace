package com.doctor.appointment.repository;

import com.doctor.appointment.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
