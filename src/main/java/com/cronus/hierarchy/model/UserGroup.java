package com.cronus.hierarchy.model;

import jakarta.persistence.*;
import lombok.Data;

// criando a entidade usergroup
@Entity
@Data
public class UserGroup {

    // criando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // muitos registros de usergroup podem se referir a um unico user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // muitos registros de usergroup podem se referir a um unico group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    // Define o papel do user dentro do grupo
    @Enumerated(EnumType.STRING)
    private Role role;
}
