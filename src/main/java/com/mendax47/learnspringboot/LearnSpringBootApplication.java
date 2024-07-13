package com.mendax47.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareString")
public class LearnSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}