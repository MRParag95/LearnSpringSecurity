package com.mendax47.learnspringboot.module.user.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.dtos.responses.PageDataResponseDTO;
import com.mendax47.learnspringboot.generics.services.ICRUDService;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;

public interface IUserService extends ICRUDService< User, UserRequestDto, GenericResponseDTO > {
    @Override
    GenericResponseDTO create( UserRequestDto requestDto );

    @Override
    PageDataResponseDTO readAll(int pageNumber, int pageSize);
}