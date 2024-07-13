package com.mendax47.learnspringboot.module.user.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;
import com.mendax47.learnspringboot.module.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public GenericResponseDTO create( UserRequestDto requestDto ) {
        UserRequestDto cleanedUserRequestDTOFields = cleanDTOFields( requestDto );
        validate( cleanedUserRequestDTOFields );
        userRepository.save( toEntityConverter( cleanedUserRequestDTOFields, null ) );

        return GenericResponseDTO
                .builder()
                .statusCode( HttpStatus.CREATED.toString() )
                .statusMessage( "User Created Successfully." )
                .build();
    }

    private UserRequestDto cleanDTOFields( UserRequestDto userRequestDto ) {
        return new UserRequestDto(
                userRequestDto.id(),
                userRequestDto.firstName().strip(),
                userRequestDto.lastName().strip(),
                userRequestDto.username().strip(),
                userRequestDto.email().strip(),
                userRequestDto.password().strip()
        );
    }

    private void validate( UserRequestDto requestDto ) {
        User foundUser = userRepository.findByUsernameOrEmail( requestDto.username(), requestDto.email() );

        if ( foundUser != null ) {
            throw new RuntimeException( "Email address or Username is already in use." );
        }
    }

    private User toEntityConverter( UserRequestDto requestDto, User user ) {
        if ( user == null ) {
            user = new User();
        }

        user.setId( requestDto.id() );
        user.setFirstName( requestDto.firstName() );
        user.setLastName( requestDto.lastName() );
        user.setUsername( requestDto.username() );
        user.setEmail( requestDto.email() );
        user.setPassword( requestDto.password() );

        return user;
    }
}