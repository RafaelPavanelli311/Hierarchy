package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  relaciona o UserTeam a um usuario
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // indica a qual time este relacionamento pertence
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // papel do user dentro do time
    @Enumerated(EnumType.STRING)
    private Role role;

}
