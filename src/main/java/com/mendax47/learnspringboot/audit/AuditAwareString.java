package com.mendax47.learnspringboot.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareString implements AuditorAware< String > {
    @Override
    public Optional< String > getCurrentAuditor() {
        return Optional.of( "Mendax47" );
    }
}
