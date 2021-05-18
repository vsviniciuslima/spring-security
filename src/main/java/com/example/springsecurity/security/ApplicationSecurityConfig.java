package com.example.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    /* v1
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // i want to authorize requests
                .anyRequest()   // any requests
                .authenticated() // must be authenticated -> the client must specify the username and password
                .and()
                .httpBasic(); // i want to use basic authentication

        // drawback -> you can't log out because the username and password is sent on every request, and the server will have to check it
    }
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // i want to authorize requests
                .antMatchers("/", "index", "/css/*", "/js/*") // i want to refer requests to these paths
                .permitAll() // permit all of them
                .anyRequest()   // any requests
                .authenticated() // must be authenticated -> the client must specify the username and password
                .and()
                .httpBasic(); // i want to use basic authentication

        // drawback -> you can't log out because the username and password is sent on every request, and the server will have to check it
    }
}
