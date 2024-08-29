package com.scm.scm2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.scm2.Services.impl.SecurityCustomUserDetailService;

import lombok.experimental.var;

@Configuration
public class SecurityConfig {

    //user create and login using java code with in memory  service
    //private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user1 = User
    //     .withDefaultPasswordEncoder()
    //     .username("admin123")
    //     .password("admin123")
    //     .roles("ADMIN","USER")
    //     .build();

    //     UserDetails user2 = User
    //     .withDefaultPasswordEncoder()
    //     .username("tusher")
    //     .password("tusher")
    //     //.roles("ADMIN","USER")
    //     .build();

    //     var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2);
    //     return inMemoryUserDetailsManager;
    // }

    //database calling login
    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    // configure authentication provider for spring security
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //user detail service object
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        //password encoder service object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    
    //url configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //configuration

        httpSecurity.authorizeHttpRequests(authorize->{
            //authorize.requestMatchers("/home","/signup","/services").permitAll();

            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        //form default login
        httpSecurity.formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
}
