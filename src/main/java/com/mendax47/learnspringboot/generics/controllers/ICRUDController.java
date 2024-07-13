package com.mendax47.learnspringboot.generics.controllers;

import org.springframework.http.ResponseEntity;

public interface ICRUDController<E, RE, RES> {
    ResponseEntity<RES> create(RE requestDto);
}