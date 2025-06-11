package com.cronus.hierarchy.dto;

import com.cronus.hierarchy.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddMemberDTO {
    // email do user que será adicionado a algum contexto (organization, group ou team)
    private String userEmail;
    // Role que o user terá dentro do contexto
    private Role role;
}
