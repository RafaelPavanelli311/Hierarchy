package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// gerencia as associações entre users e organization
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Long> {
    Optional<UserOrganization> findByOrganizationIdAndUserEmail(Long organizationId, String email);
}
