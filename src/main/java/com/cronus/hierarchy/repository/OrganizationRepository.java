package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// essa interface vai permitir fazer operações no banco de dados para a entidade organization
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
