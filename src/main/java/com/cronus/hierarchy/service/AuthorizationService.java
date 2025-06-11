package com.cronus.hierarchy.service;

import com.cronus.hierarchy.model.Role;
import com.cronus.hierarchy.repository.UserGroupRepository;
import com.cronus.hierarchy.repository.UserOrganizationRepository;
import com.cronus.hierarchy.repository.UserTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

// classe criada para verificar se um user possui cargo (role) em uma ORG, GROUP ou TEAM
@Service("authz")
public class AuthorizationService {

    @Autowired
    private UserOrganizationRepository userOrganizationRepository;
    private UserGroupRepository userGroupRepository;
    private UserTeamRepository userTeamRepository;

    // verifica se um user (por e-mail) possui qualquer um dos cargos permitidos (allowedRoles) em uma organization específica (organizationId)
    public boolean hasOrganizationRole(Long organizationId, String email, Role... allowedRoles) {
        return userOrganizationRepository.findByOrganizationIdAndUserEmail(organizationId, email)
                .map(uo -> Arrays.asList(allowedRoles).contains(uo.getRole()))
                .orElse(false);
    }

    // verifica se um user (por e-mail) possui qualquer um dos cargos permitidos (allowedRoles) em um group específico (groupId)
    public boolean hasGroupRole(Long groupId, String email, Role... allowedRoles) {
        return userGroupRepository.findByGroupIdAndUserEmail(groupId, email)
                .map(ug -> Arrays.asList(allowedRoles).contains(ug.getRole()))
                .orElse(false);
    }
    // verifica se um user (por e-mail) possui qualquer um dos cargos permitidos (allowedRoles) em um team específico (groupId)
    public boolean hasTeamRole(Long teamId, String email, Role... allowedRoles) {
        return userTeamRepository.findByTeamIdAndUserEmail(teamId, email)
                .map(ut -> Arrays.asList(allowedRoles).contains(ut.getRole()))
                .orElse(false);
    }
}

