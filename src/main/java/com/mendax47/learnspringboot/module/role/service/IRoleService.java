package com.mendax47.learnspringboot.module.role.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.services.ICRUDService;
import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.role.dtos.requests.RoleRequestDTO;
import com.mendax47.learnspringboot.module.role.dtos.responses.CustomRoleResponseDTO;

public interface IRoleService extends ICRUDService< Role, RoleRequestDTO, GenericResponseDTO, CustomRoleResponseDTO > {
}