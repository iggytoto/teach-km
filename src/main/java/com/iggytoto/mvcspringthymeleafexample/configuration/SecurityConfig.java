package com.iggytoto.mvcspringthymeleafexample.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder).and().build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(PageNameConstants.LOGIN).permitAll()
                .requestMatchers(PageNameConstants.REGISTER).permitAll()
                .requestMatchers(PageNameConstants.NOTES).authenticated()
                .and()
                .formLogin()
                .loginPage(PageNameConstants.LOGIN)
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl(PageNameConstants.NOTES)
                .failureForwardUrl(PageNameConstants.REGISTER)
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }
}
