package com.mendax47.learnspringboot.module.role.repository;

import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.role.dtos.responses.CustomRoleResponseDTO;
import com.mendax47.learnspringboot.module.role.enums.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleRepository extends JpaRepository< Role, Long >, JpaSpecificationExecutor< Role > {
    Role findByRoleType( RoleType roleType );

    Boolean existsByRoleType( RoleType roleType );

    @EntityGraph( attributePaths = { "users" } )
    @Query( """
                SELECT
                    role
                FROM Role role
            """ )
    Page< CustomRoleResponseDTO > findAllRoles( Pageable pageable );

    @EntityGraph( attributePaths = { "users" } )
    CustomRoleResponseDTO findRoleById( Long id );

    @EntityGraph( attributePaths = { "users" } )
    Set< Role > findAllByIdIn( Set< Long > ids );
}