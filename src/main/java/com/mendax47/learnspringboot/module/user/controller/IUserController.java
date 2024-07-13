package com.mendax47.learnspringboot.module.user.controller;

import com.mendax47.learnspringboot.generics.controllers.ICRUDController;
import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface IUserController extends ICRUDController<User, UserRequestDto, GenericResponseDTO> {
    @Override
    ResponseEntity<GenericResponseDTO> create(UserRequestDto request);
}