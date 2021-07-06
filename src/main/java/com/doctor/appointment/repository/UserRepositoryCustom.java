package com.doctor.appointment.repository;

import com.doctor.appointment.dto.AuthDto;
import com.doctor.appointment.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<AuthDto> getByEmailWithPasswordAndRole(String email);

    List<User> getPaginatedUsers(int firstResults, int maxResults);
    long getTotalUsers();
}
