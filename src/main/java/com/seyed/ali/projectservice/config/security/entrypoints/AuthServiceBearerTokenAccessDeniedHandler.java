package com.seyed.ali.projectservice.config.security.entrypoints;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * This class handles unauthorized users.
 */
@Component
public class AuthServiceBearerTokenAccessDeniedHandler implements AccessDeniedHandler {

    private final HandlerExceptionResolver resolver;

    @Autowired
    public AuthServiceBearerTokenAccessDeniedHandler(
            @Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver
    ) {
        this.resolver = resolver;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        this.resolver.resolveException(request, response, null, accessDeniedException);
    }

}
