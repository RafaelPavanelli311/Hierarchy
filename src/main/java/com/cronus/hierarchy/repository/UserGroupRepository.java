package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// gerencia as associações entre users e groups
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findByGroupIdAndUserEmail(Long groupId, String email);
}
