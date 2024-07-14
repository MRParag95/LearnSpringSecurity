package com.mendax47.learnspringboot.config.security;

import com.mendax47.learnspringboot.constants.routers.PermittedRoutes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception {
        http
                .cors( AbstractHttpConfigurer::disable )
                .csrf( AbstractHttpConfigurer::disable )
                .authorizeHttpRequests(( httpRequests ) -> {
                    httpRequests
                            .requestMatchers( PermittedRoutes.ROUTES )
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin( Customizer.withDefaults() )
                .httpBasic( Customizer.withDefaults() );

        return http.build();
    }
}