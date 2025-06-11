package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// criando o team (entidade)
@Entity
@Data
public class Team {

    // criando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // criando o name
    private String name;

    // cada team pertence a um group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    // um team tem muitos UserTeam (muitos users vinculados a esse team)
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<UserTeam> users;
}