package com.mendax47.learnspringboot.module.user.dtos.responses;

import com.mendax47.learnspringboot.module.role.enums.RoleType;

import java.util.Set;

/**
 * Projection for {@link com.mendax47.learnspringboot.module.user.User}
 */

public interface SingleUserResponseDTO {
    Long getId();

    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    Set< RoleInfo > getRoles();

    /**
     * Projection for {@link com.mendax47.learnspringboot.module.role.Role}
     */
    interface RoleInfo {
        Long getId();

        RoleType getRoleType();
    }
}