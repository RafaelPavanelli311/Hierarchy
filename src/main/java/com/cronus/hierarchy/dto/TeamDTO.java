package com.cronus.hierarchy.dto;

import lombok.Data;

@Data
public class TeamDTO {

    // nome do team que está sendo criado ou manipulado
    private String name;
    // id do group ao qual esse time pertence
    private Long groupId;
}
