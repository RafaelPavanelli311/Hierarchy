package com.cronus.hierarchy.controllers;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.GroupDTO;
import com.cronus.hierarchy.model.Group;
import com.cronus.hierarchy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    // endpoint para criar um novo group
    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody GroupDTO dto,
                                             @AuthenticationPrincipal String userEmail) {
        Group group = groupService.createGroup(dto, userEmail);
        return ResponseEntity.ok(group);
    }

    // endpoint para adicionar um membro a um grupo existente
    @PostMapping("/{groupId}/members")
    public ResponseEntity<Void> addMember(@PathVariable Long groupId,
                                          @RequestBody AddMemberDTO dto,
                                          @AuthenticationPrincipal String userEmail) {
        groupService.addMemberToGroup(groupId, dto, userEmail);
        return ResponseEntity.ok().build();
    }

    // endpoint para remover um membro de um goup
    @DeleteMapping("/{groupId}/members/{userGroupId}")
    public ResponseEntity<Void> removeMember(@PathVariable Long groupId,
                                             @PathVariable Long userGroupId,
                                             @AuthenticationPrincipal String userEmail) {
        groupService.removeMemberFromGroup(groupId, userGroupId, userEmail);
        return ResponseEntity.ok().build();
    }

    // endpoint para deletar um group
    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long groupId,
                                            @AuthenticationPrincipal String userEmail) {
        groupService.deleteGroup(groupId, userEmail);
        return ResponseEntity.ok().build();
    }
}

