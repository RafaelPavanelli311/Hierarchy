package com.cronus.hierarchy.controllers;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.OrganizationDTO;
import com.cronus.hierarchy.model.Organization;
import com.cronus.hierarchy.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // endpoint para criar uma nova organization
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationDTO dto,
                                                           @AuthenticationPrincipal String userEmail) {
        Organization organization = organizationService.createOrganization(dto, userEmail);
        return ResponseEntity.ok(organization);
    }

    // endpoint para adicionar um novo membro a uma organization
    @PostMapping("/{organizationId}/members")
    public ResponseEntity<Void> addMember(@PathVariable Long organizationId,
                                          @RequestBody AddMemberDTO dto,
                                          @AuthenticationPrincipal String userEmail) {
        organizationService.addMemberToOrganization(organizationId, dto, userEmail);
        return ResponseEntity.ok().build();
    }

    // endpoint para deletar uma organization
    @DeleteMapping("/{organizationId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long organizationId,
                                                   @AuthenticationPrincipal String userEmail) {
        organizationService.deleteOrganization(organizationId, userEmail);
        return ResponseEntity.ok().build();
    }
}


