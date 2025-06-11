package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class UserOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // cada UserOrganization esta vinculado a um usuário específico
    @ManyToOne
    private User user;

    // cada UserOrganization esta vinculado a uma organização especifica
    @ManyToOne
    private Organization organization;

    // representa o role do user dentro da organization
    @Enumerated(EnumType.STRING)
    private Role role;
}
