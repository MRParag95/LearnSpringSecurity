package com.mendax47.learnspringboot.generics.services;

import com.mendax47.learnspringboot.generics.dtos.responses.PageDataResponseDTO;

public interface ICRUDService<E, RE, RES> {
    RES create(RE requestDto);
    PageDataResponseDTO readAll(int pageNumber, int pageSize);
}