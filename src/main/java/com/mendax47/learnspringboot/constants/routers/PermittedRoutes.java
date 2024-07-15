package com.mendax47.learnspringboot.constants.routers;

public final class PermittedRoutes {
    public static final String[] ROUTES = new String[] {
            "v3/api-docs/**",
            "swagger-ui/**",
            UserRoutes.USER_ROUTE + "/" + UserRoutes.USER_REGISTRATION
    };
}