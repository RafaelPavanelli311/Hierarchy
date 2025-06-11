package com.cronus.hierarchy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cronus.hierarchy.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// gerencia os users na aplicação
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
