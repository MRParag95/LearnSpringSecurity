package com.mendax47.learnspringboot.module.role.repository;

import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.role.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository< Role, Long >, JpaSpecificationExecutor< Role > {
    Role findByRoleType( RoleType roleType );
    Boolean existsByRoleType( RoleType roleType );
}