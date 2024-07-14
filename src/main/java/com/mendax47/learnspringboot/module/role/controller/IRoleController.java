package com.mendax47.learnspringboot.module.role.controller;

import com.mendax47.learnspringboot.generics.controllers.ICRUDController;
import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.role.dtos.requests.RoleRequestDTO;
import com.mendax47.learnspringboot.module.role.dtos.responses.CustomRoleResponseDTO;

public interface IRoleController extends ICRUDController< Role, RoleRequestDTO, GenericResponseDTO, CustomRoleResponseDTO > {
}