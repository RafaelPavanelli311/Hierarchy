package com.cronus.hierarchy.service;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.TeamDTO;
import com.cronus.hierarchy.exception.AccessDeniedException;
import com.cronus.hierarchy.model.*;
import com.cronus.hierarchy.repository.TeamRepository;
import com.cronus.hierarchy.repository.UserRepository;
import com.cronus.hierarchy.repository.UserTeamRepository;
import com.cronus.hierarchy.repository.OrganizationRepository;
import com.cronus.hierarchy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private UserTeamRepository userTeamRepository;
    private AuthorizationService authorizationService;
    private OrganizationRepository organizationRepository;
    private final UserOrganizationRepository userOrganizationRepository;
    private AuthorizationService authz;

    // cria um novo team e define o user que criou ela como o OWNER
    public Team createTeam(TeamDTO dto, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Team team = new Team();
        team.setName(dto.getName());

        Team savedTeam = teamRepository.save(team);

        UserTeam userTeam = new UserTeam();
        userTeam.setUser(user);
        userTeam.setTeam(savedTeam);
        userTeam.setRole(Role.OWNER);

        userTeamRepository.save(userTeam);

        return savedTeam;
    }


    // adiciona um novo membro a um team ja existente
    public void addMemberToTeam(Long teamId, AddMemberDTO dto, String requestingUserEmail) {
        boolean hasPermission = authorizationService.hasTeamRole(teamId, requestingUserEmail, Role.OWNER, Role.ADMIN);

        if (!hasPermission) {
            throw new AccessDeniedException("You do not have permission to add members to this team.");
        }

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        User user = userRepository.findByEmail(dto.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserTeam userTeam = new UserTeam();
        userTeam.setUser(user);
        userTeam.setTeam(team);
        userTeam.setRole(dto.getRole());

        userTeamRepository.save(userTeam);
    }

    // remove um membro de um team, tem que possuir o cargo admin ou owner
    public void removeMemberFromTeam(Long teamId, Long userTeamId, String email) {
        boolean hasPermission = authorizationService.hasTeamRole(teamId, email, Role.OWNER, Role.ADMIN);

        if (!hasPermission) {
            throw new AccessDeniedException("You do not have permission to remove members from this team.");
        }

        userTeamRepository.deleteById(userTeamId);
    }

    // deleta o team, tem que possuir o cargo de owner
    public void deleteTeam(Long teamId, String requestingUserEmail) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        if (!authz.hasTeamRole(teamId, requestingUserEmail, Role.OWNER)) {
            throw new AccessDeniedException("Only the team owner can delete it");
        }

        teamRepository.deleteById(teamId);
    }




}
