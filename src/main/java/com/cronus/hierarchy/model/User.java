package com.cronus.hierarchy.model;

import jakarta.persistence.*;

import java.util.List;

// criando o user (entidade)
@Entity
public class User {

    // criando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // criando o name
    private String name;
    // criando o email
    private String email;
    // criando a senha
    private String password;

    // um user pode estar em mais de uma organization
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserOrganization> organizations;

    // um user pode estar em mais de um group
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroup> groups;

    // um user pode estar em mais de um team
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserTeam> teams;
}
