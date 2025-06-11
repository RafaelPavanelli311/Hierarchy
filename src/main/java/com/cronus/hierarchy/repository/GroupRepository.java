package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// essa interface vai permitir fazer operações no banco de dados para a entidade group
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
