package com.doctor.appointment.repository;

import com.doctor.appointment.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
