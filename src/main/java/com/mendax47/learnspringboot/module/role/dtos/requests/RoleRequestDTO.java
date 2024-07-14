package com.mendax47.learnspringboot.module.role.dtos.requests;

import com.mendax47.learnspringboot.module.role.enums.RoleType;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.mendax47.learnspringboot.module.role.Role}
 */

public record RoleRequestDTO(
        Long id,
        @NotNull RoleType roleType
) implements Serializable {
}