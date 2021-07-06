package com.doctor.appointment.repository;

import com.doctor.appointment.dto.AuthDto;
import com.doctor.appointment.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<AuthDto> getByEmailWithPasswordAndRole(String email) {

        String query = "select new com.doctor.appointment.dto.AuthDto" +
                " (d.email, d.password, d.role.role) " +
                " from User d " +
                " where d.email = :email ";

        AuthDto authDto =
                entityManager.createQuery(query, AuthDto.class)
                .setParameter("email", email)
                .getSingleResult();

        return Optional.of(authDto);
    }

    @Override
    public List<User> getPaginatedUsers(int firstResults, int maxResults) {

        String query = "select d from User d ";

        List<User> users = entityManager.createQuery(query, User.class)
                .setFirstResult(firstResults)
                .setMaxResults(maxResults)
                .getResultList();

        return users;
    }



    @Override
    public long getTotalUsers() {

        String query = "select count(d) from User d ";

        long totalUsers = entityManager.createQuery(query, Long.class)
                .getSingleResult();
        return totalUsers;
    }
}
