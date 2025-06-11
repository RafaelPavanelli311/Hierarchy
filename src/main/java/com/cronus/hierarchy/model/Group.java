package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// criando o group (entidade)
@Entity
@Data
public class Group {

    // criando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // criando o name
    private String name;

    // cada grupo pertence a uma unica organization
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    // um group possui varios teams
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Team> teams;

    // um grupo possui vários usuários associados através da entidade de junção UserGroup
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<UserGroup> users;
}
