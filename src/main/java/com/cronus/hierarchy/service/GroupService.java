package com.cronus.hierarchy.service;

import com.cronus.hierarchy.dto.AddMemberDTO;
import com.cronus.hierarchy.dto.GroupDTO;
import com.cronus.hierarchy.exception.AccessDeniedException;
import com.cronus.hierarchy.model.*;
import com.cronus.hierarchy.repository.GroupRepository;
import com.cronus.hierarchy.repository.OrganizationRepository;
import com.cronus.hierarchy.repository.UserGroupRepository;
import com.cronus.hierarchy.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    @Autowired
    private AuthorizationService authz;
    private final GroupRepository groupRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    // cria um novo group dentro de uma organization, o user que chamar este endpoint se tornará OWNER desse group
    public Group createGroup(GroupDTO dto, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Group group = new Group();
        group.setName(dto.getName());

        Organization organization = organizationRepository.findById(dto.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));

        group.setOrganization(organization);
        Group saved = groupRepository.save(group);

        UserGroup userGroup = new UserGroup();
        userGroup.setUser(user);
        userGroup.setGroup(saved);
        userGroup.setRole(Role.OWNER);
        userGroupRepository.save(userGroup);

        return saved;
    }
    // adiciona um novo membro a um grupo existente, somente OWNER ou ADMIN do grupo podem realizar essa ação
    public void addMemberToGroup(Long groupId, AddMemberDTO dto, String requestingUserEmail) {
        if (!authz.hasGroupRole(groupId, requestingUserEmail, Role.OWNER, Role.ADMIN)) {
            throw new AccessDeniedException("Access denied");
        }

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        User user = userRepository.findByEmail(dto.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserGroup userGroup = new UserGroup();
        userGroup.setUser(user);
        userGroup.setGroup(group);
        userGroup.setRole(dto.getRole());

        userGroupRepository.save(userGroup);
    }
    // remove um membro de um group específico, só OWNER ou ADMIN do grupo poderão remover membros
    public void removeMemberFromGroup(Long groupId, Long userGroupId, String requestingUserEmail) {
        if (!authz.hasGroupRole(groupId, requestingUserEmail, Role.OWNER, Role.ADMIN)) {
            throw new AccessDeniedException("Access denied");
        }

        UserGroup userGroup = userGroupRepository.findById(userGroupId)
                .orElseThrow(() -> new EntityNotFoundException("UserGroup not found."));

        if (!userGroup.getGroup().getId().equals(groupId)) {
            throw new IllegalArgumentException("This user is not part of the specified group.");
        }

        userGroupRepository.deleteById(userGroupId);
    }

    // remove um group garantindo que o usuário autenticado, seja o proprietário (OWNER) do group para executar a ação
    public void deleteGroup(Long groupId, String requestingUserEmail) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        if (!authz.hasGroupRole(groupId, requestingUserEmail, Role.OWNER)) {
            throw new AccessDeniedException("Only the group owner can delete it");
        }

        groupRepository.deleteById(groupId);
    }

}
