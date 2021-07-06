package com.doctor.appointment.repository;

import com.doctor.appointment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
