package com.doctor.appointment.repository;

import com.doctor.appointment.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
