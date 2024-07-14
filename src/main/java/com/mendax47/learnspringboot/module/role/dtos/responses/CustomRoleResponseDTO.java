package com.mendax47.learnspringboot.module.role.dtos.responses;

import com.mendax47.learnspringboot.module.role.enums.RoleType;

import java.util.Set;

/**
 * Projection for {@link com.mendax47.learnspringboot.module.role.Role}
 */

public interface CustomRoleResponseDTO {
    Long getId();

    RoleType getRoleType();

    Set< UserInfo > getUsers();

    /**
     * Projection for {@link com.mendax47.learnspringboot.module.user.User}
     */
    interface UserInfo {
        Long getId();

        String getFirstName();

        String getLastName();

        String getUsername();

        String getEmail();
    }
}