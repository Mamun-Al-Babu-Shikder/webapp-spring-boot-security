package com.mcubes.websecurity;

import com.mcubes.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Created by A.A.MAMUN on 12/16/2019.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    public AuthenticationProvider authenticationProviderHandler(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/home","/login","/registration").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/**").access("hasRole('ROLE_USER)")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .successHandler(new MyAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .clearAuthentication(true);
                */

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/static/**","/css/**","/js/**","/fonts/**","vendor/**")
                .permitAll()
                .antMatchers("/home","/login","/registration").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .successHandler(new MyAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .clearAuthentication(true);
    }
}
