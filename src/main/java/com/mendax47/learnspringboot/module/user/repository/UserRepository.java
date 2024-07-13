package com.mendax47.learnspringboot.module.user.repository;

import com.mendax47.learnspringboot.module.user.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository< User, Long >, JpaSpecificationExecutor< User > {
    User findByUsernameOrEmail( String username, String email );

    @Query( """
                SELECT
                    user
                FROM
                    User user
            """ )
    Page< User > findAllUsers( Pageable pageable );
}