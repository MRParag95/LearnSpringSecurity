package com.mendax47.learnspringboot.constants.routers;

public final class PermittedRoutes {
    public static final String[] ROUTES = new String[] {
            "/swagger-ui/**",
            "/" + UserRoutes.USER_ROUTE + "/" + UserRoutes.USER_REGISTRATION
    };
}