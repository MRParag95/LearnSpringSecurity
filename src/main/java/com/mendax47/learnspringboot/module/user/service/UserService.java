package com.mendax47.learnspringboot.module.user.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.dtos.responses.PageDataResponseDTO;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.dtos.requests.UserRequestDto;
import com.mendax47.learnspringboot.module.user.dtos.responses.CustomUserResponseDTO;
import com.mendax47.learnspringboot.module.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public GenericResponseDTO create( UserRequestDto requestDto ) {
        UserRequestDto cleanedUserRequestDTOFields = cleanDTOFields( requestDto );
        validate( cleanedUserRequestDTOFields, null );
        userRepository.save( toEntityConverter( cleanedUserRequestDTOFields, null ) );

        return GenericResponseDTO
                .builder()
                .statusCode( HttpStatus.CREATED.toString() )
                .statusMessage( "User Created Successfully." )
                .build();
    }

    @Override
    public PageDataResponseDTO readAll( int pageNumber, int pageSize ) {
        Pageable pageable = PageRequest.of( pageNumber - 1, pageSize );
        Page< CustomUserResponseDTO > allUsers = userRepository.findAllUsers( pageable );

        return PageDataResponseDTO
                .builder()
                .model( allUsers.getContent() )
                .totalElements( allUsers.getTotalElements() )
                .totalPages( allUsers.getTotalPages() )
                .currentPage( allUsers.getNumber() + 1 )
                .build();
    }

    @Override
    public CustomUserResponseDTO readOne( Long id ) {
        return userRepository.findSingleUserById( id );
    }

    @Override
    public GenericResponseDTO update( UserRequestDto requestDto ) {
        UserRequestDto cleanedUserRequestDTOFields = cleanDTOFields( requestDto );
        User foundUser = userRepository
                .findById( cleanedUserRequestDTOFields.id() )
                .orElseThrow( () -> new RuntimeException( "User Not Found." ) );
        validate( cleanedUserRequestDTOFields, foundUser );
        userRepository.save( toEntityConverter( cleanedUserRequestDTOFields, foundUser ) );

        return GenericResponseDTO
                .builder()
                .statusCode( HttpStatus.OK.toString() )
                .statusMessage( "User Updated Successfully." )
                .build();
    }

    @Override
    public GenericResponseDTO delete( Long id ) {
        return null;
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

    private void validate( UserRequestDto requestDto, User user ) {
        if ( Objects.isNull( user ) ) {
            User foundUser = userRepository.findByUsernameOrEmail( requestDto.username(), requestDto.email() );

            if ( Objects.nonNull( foundUser ) ) {
                throw new RuntimeException( "Email address or Username is already in use." );
            }
        } else {
            if ( ( !Objects.equals( requestDto.username(), user.getUsername() ) && userRepository.existsByUsername( requestDto.username() ) )
                    || ( !Objects.equals( requestDto.email(), user.getEmail() ) && userRepository.existsByEmail( requestDto.email() ) )
            ) {
                throw new RuntimeException( "Email address or Username is already in use." );
            }
        }
    }

    private User toEntityConverter( UserRequestDto requestDto, User user ) {
        if ( Objects.isNull( user ) ) {
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