package com.cronus.hierarchy.repository;

import com.cronus.hierarchy.model.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// gerencia as associações entre usuers e groups
public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
    Optional<UserTeam> findByTeamIdAndUserEmail(Long teamId, String email);
    List<UserTeam> findByTeamId(Long teamId);
}

