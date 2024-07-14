package com.mendax47.learnspringboot.module.role.service;

import com.mendax47.learnspringboot.generics.dtos.responses.GenericResponseDTO;
import com.mendax47.learnspringboot.generics.dtos.responses.PageDataResponseDTO;
import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.role.dtos.requests.RoleRequestDTO;
import com.mendax47.learnspringboot.module.role.dtos.responses.CustomRoleResponseDTO;
import com.mendax47.learnspringboot.module.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Override
    public GenericResponseDTO create( RoleRequestDTO requestDto ) {
        RoleRequestDTO cleanedRoleRequestDTOFields = cleanDTOFields( requestDto );
        validate( cleanedRoleRequestDTOFields, null );
        roleRepository.save( toEntityConverter( cleanedRoleRequestDTOFields, null ) );

        return GenericResponseDTO
                .builder()
                .statusCode( HttpStatus.CREATED.toString() )
                .statusMessage( "Role Created Successfully." )
                .build();
    }

    @Override
    public PageDataResponseDTO readAll( int pageNumber, int pageSize ) {
        return null;
    }

    @Override
    public CustomRoleResponseDTO readOne( Long id ) {
        return null;
    }

    @Override
    public GenericResponseDTO update( RoleRequestDTO requestDto ) {
        return null;
    }

    @Override
    public GenericResponseDTO delete( Long id ) {
        return null;
    }

    private RoleRequestDTO cleanDTOFields( RoleRequestDTO requestDto ) {
        return new RoleRequestDTO(
                requestDto.id(),
                requestDto.roleType()
        );
    }

    private void validate( RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            Role foundRole = roleRepository.findByRoleType( requestDto.roleType() );

            if ( Objects.nonNull( foundRole ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        } else {
            if ( ( !( Objects.equals( requestDto.roleType(), role.getRoleType() ) ) && roleRepository.existsByRoleType( requestDto.roleType() ) ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        }
    }

    private Role toEntityConverter( RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            role = new Role();
        }

        role.setId( requestDto.id() );
        role.setRoleType( requestDto.roleType() );

        return role;
    }

    private void deleteValidator( Role role ) {
    }
}