package com.mendax47.learnspringboot.module.user.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.dtos.responses.PageDataResponseDTO;
import com.mendax47.learnspringboot.generics.services.ICRUDService;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;
import com.mendax47.learnspringboot.module.user.dtos.responses.SingleUserResponseDTO;

public interface IUserService extends ICRUDService< User, UserRequestDto, GenericResponseDTO, SingleUserResponseDTO > {
    @Override
    GenericResponseDTO create( UserRequestDto requestDto );

    @Override
    PageDataResponseDTO readAll(int pageNumber, int pageSize);

    @Override
    SingleUserResponseDTO readOne( Long id );
}