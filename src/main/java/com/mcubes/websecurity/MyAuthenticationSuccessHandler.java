package com.mcubes.websecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Authentication authentication) throws IOException, ServletException {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        String role = authentication.getAuthorities().toArray()[0].toString();

        if(role.equals("ROLE_ADMIN")){
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin/profile");
        }else if(role.equals("ROLE_USER")){
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/user/profile");
        }

    }
}