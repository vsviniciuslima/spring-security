package com.example.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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

    @Override
    @Bean
    // how you retrieve a user from a database
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("password"))
                .roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                annaSmithUser,
                lindaUser
        );
    }
}
