package com.mendax47.learnspringboot.module.user.controller;

import com.mendax47.learnspringboot.constants.routers.UserRoutes;
import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;
import com.mendax47.learnspringboot.module.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping( UserRoutes.USER_ROUTE )
public class UserController implements IUserController {
    private final IUserService userService;

    @PostMapping( UserRoutes.USER_REGISTRATION )
    @Override
    public ResponseEntity< GenericResponseDTO > create( @Validated UserRequestDto requestDto ) {
        return ResponseEntity
                .ok()
                .body( userService.create( requestDto ) );
    }
}