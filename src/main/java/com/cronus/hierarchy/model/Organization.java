package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// criando a organization (entidade)
@Entity
@Data
public class Organization {

    // criando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // criando o name
    private String name;

    // o lado dono da relação esta na entidade group
    // conseguir acessar todos os groups dentro de uma organização
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Group> groups;

    // permissão de acessar todos os membros da organizaçao
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<UserOrganization> users;
}