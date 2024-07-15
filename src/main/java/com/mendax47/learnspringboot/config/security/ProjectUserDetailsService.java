package com.mendax47.learnspringboot.config.security;

import com.mendax47.learnspringboot.module.role.Role;
import com.mendax47.learnspringboot.module.user.User;
import com.mendax47.learnspringboot.module.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsernameOrEmail( username.strip(), username.strip() );
        if ( Objects.isNull( foundUser ) ) {
            throw new UsernameNotFoundException( username );
        }

        List< GrantedAuthority > grantedAuthorities = foundUser
                .getRoles()
                .stream()
                .map( role -> new SimpleGrantedAuthority( role.getId().toString() ) )
                .collect( Collectors.toList());

        return new org.springframework.security.core.userdetails.User( foundUser.getUsername(), foundUser.getPassword(), grantedAuthorities );
    }
}
