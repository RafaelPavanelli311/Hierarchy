package com.cronus.hierarchy.controllers;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.TeamDTO;
import com.cronus.hierarchy.model.Team;
import com.cronus.hierarchy.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    // endpoint para criar um novo team
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO dto, @AuthenticationPrincipal UserDetails userDetails) {
        Team team = teamService.createTeam(dto, userDetails.getUsername());
        return ResponseEntity.ok(team);
    }

    // endpoint para adicionar um membro a um team
    @PostMapping("/{teamId}/members")
    public ResponseEntity<Void> addMemberToTeam(
            @PathVariable Long teamId,
            @RequestBody AddMemberDTO dto,
            @AuthenticationPrincipal UserDetails userDetails) {

        String requestingUserEmail = userDetails.getUsername();
        teamService.addMemberToTeam(teamId, dto, requestingUserEmail);
        return ResponseEntity.ok().build();
    }

    // endpoint para remover um member do team
    @DeleteMapping("/{teamId}/members/{userTeamId}")
    public ResponseEntity<Void> removeMemberFromTeam(
            @PathVariable Long teamId,
            @PathVariable Long userTeamId,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        teamService.removeMemberFromTeam(teamId, userTeamId, userDetails.getUsername());
        return ResponseEntity.ok().build();
    }

    // endpoit para deletar um team
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId, @RequestHeader("X-User-Email") String userEmail) {
        teamService.deleteTeam(teamId, userEmail);
        return ResponseEntity.noContent().build();
    }


}
