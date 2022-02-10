package com.cleverdeveloper.springsecurity;

/*
PROJECT NAME : 23. REST and Spring Security
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 10/02/2022 22:43
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
    }
}
