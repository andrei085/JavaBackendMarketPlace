package com.shop.marketplace.repository;

import com.shop.marketplace.dto.AuthDto;
import com.shop.marketplace.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<AuthDto> getByEmailWithPasswordAndRole(String email);

    List<User> getPaginatedUsers(int firstResults, int maxResults);
    long getTotalUsers();
}
