package com.mendax47.learnspringboot.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final ProjectUserDetailsService projectUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = projectUserDetailsService.loadUserByUsername(username);

        if ( passwordEncoder.matches(password, userDetails.getPassword()) ) {
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
        else {
            throw new BadCredentialsException( "Invalid Password" );
        }
    }

    @Override
    public boolean supports( Class< ? > authentication ) {
        return ( UsernamePasswordAuthenticationToken.class.isAssignableFrom( authentication ) );
    }
}
