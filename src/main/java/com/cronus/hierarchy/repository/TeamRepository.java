package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// essa interface vai permitir fazer operações no banco de dados para a entidade team
public interface TeamRepository extends JpaRepository<Team, Long> {
}
