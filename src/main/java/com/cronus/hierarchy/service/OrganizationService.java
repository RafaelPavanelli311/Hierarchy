package com.cronus.hierarchy.service;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.OrganizationDTO;
import com.cronus.hierarchy.exception.AccessDeniedException;
import com.cronus.hierarchy.model.Organization;
import com.cronus.hierarchy.model.User;
import com.cronus.hierarchy.model.UserOrganization;
import com.cronus.hierarchy.model.Role;
import com.cronus.hierarchy.repository.OrganizationRepository;
import com.cronus.hierarchy.repository.UserRepository;
import com.cronus.hierarchy.repository.UserOrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    @Autowired
    private AuthorizationService authz;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final UserOrganizationRepository userOrganizationRepository;

    // cria uma nova organization, o user que chamar este endpoint se tornará OWNER dessa organization
    public Organization createOrganization(OrganizationDTO dto, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Organization organization = new Organization();
        organization.setName(dto.getName());

        Organization saved = organizationRepository.save(organization);

        UserOrganization userOrg = new UserOrganization();
        userOrg.setUser(user);
        userOrg.setOrganization(saved);
        userOrg.setRole(Role.OWNER);
        userOrganizationRepository.save(userOrg);

        return saved;
    }
    // adiciona um novo membro a uma organization existente, somente OWNER ou ADMIN do grupo podem realizar essa ação
    public void addMemberToOrganization(Long organizationId, AddMemberDTO dto, String requestingUserEmail) {
        if (!authz.hasOrganizationRole(organizationId, requestingUserEmail, Role.OWNER, Role.ADMIN)) {
            throw new AccessDeniedException("Access denied");
        }

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        User user = userRepository.findByEmail(dto.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserOrganization userOrg = new UserOrganization();
        userOrg.setUser(user);
        userOrg.setOrganization(organization);
        userOrg.setRole(dto.getRole());

        userOrganizationRepository.save(userOrg);
    }

    //  remove um membro de uma organization garantindo que o user autenticado tenha permissão (OWNER ou ADMIN) para executar a ação
    public void removeMemberFromOrganization(Long organizationId, Long userOrgId, String requestingUserEmail) {
        if (!authz.hasOrganizationRole(organizationId, requestingUserEmail, Role.OWNER, Role.ADMIN)) {
            throw new AccessDeniedException("Access denied");
        }

        UserOrganization userOrganization = userOrganizationRepository.findById(userOrgId)
                .orElseThrow(() -> new EntityNotFoundException("UserOrganization not found."));

        if (!userOrganization.getOrganization().getId().equals(organizationId)) {
            throw new IllegalArgumentException("This user is not part of the specified organization.");
        }

        userOrganizationRepository.deleteById(userOrgId);
    }


    public void deleteOrganization(Long orgId, String requestingUserEmail) {
        if (!authz.hasOrganizationRole(orgId, requestingUserEmail, Role.OWNER)) {
            throw new AccessDeniedException("Only owners can delete the organization");
        }

        organizationRepository.deleteById(orgId);
    }

}
