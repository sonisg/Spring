package com.eazybytes.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesAfterFilter implements Filter {

    private final Logger LOG =
            Logger.getLogger(AuthoritiesAfterFilter.class.getName());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(null!=authentication) {
            LOG.info("User "+authentication.getName()+" is successfully authenticated and "
                    + "has the authorities "+authentication.getAuthorities().toString());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
