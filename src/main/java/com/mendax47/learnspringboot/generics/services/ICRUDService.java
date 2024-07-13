package com.mendax47.learnspringboot.generics.services;

public interface ICRUDService<E, RE, RES> {
    RES create(RE requestDto);
}