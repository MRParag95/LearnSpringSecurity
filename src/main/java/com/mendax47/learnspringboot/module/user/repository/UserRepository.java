package com.mendax47.learnspringboot.module.user.repository;

import com.mendax47.learnspringboot.module.user.User;

import com.mendax47.learnspringboot.module.user.dtos.responses.CustomUserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository< User, Long >, JpaSpecificationExecutor< User > {
    User findByUsernameOrEmail( String username, String email );

    @Query( """
                SELECT
                    user
                FROM User user
                WHERE
                    user.id = :id
            """ )
    CustomUserResponseDTO findSingleUserById(
            @Param( "id" ) Long id
    );

    @Query( """
                SELECT
                    user
                FROM
                    User user
            """ )
    Page< CustomUserResponseDTO > findAllUsers( Pageable pageable );

    boolean existsByUsername( String username );

    boolean existsByEmail( String email );
}