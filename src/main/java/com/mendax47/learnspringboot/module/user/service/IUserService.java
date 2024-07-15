package com.mendax47.learnspringboot.module.user.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.services.ICRUDService;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDTO;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRolesRequestDTO;
import com.mendax47.learnspringboot.module.user.dtos.responses.CustomUserResponseDTO;

public interface IUserService extends ICRUDService< User, UserRequestDTO, GenericResponseDTO, CustomUserResponseDTO > {
    GenericResponseDTO setUserRoles( UserRolesRequestDTO requestDTO );
}