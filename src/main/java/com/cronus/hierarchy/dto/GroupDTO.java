package com.cronus.hierarchy.dto;

import lombok.Data;

@Data
public class GroupDTO {
    // nome do grupo
    private String name;
    // id da organization a qual esse group pertence
    private Long organizationId;

}
