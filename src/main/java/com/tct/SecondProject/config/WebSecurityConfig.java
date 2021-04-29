package com.tct.SecondProject.config;

import com.tct.SecondProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
@Override
protected  void configure(AuthenticationManagerBuilder builder) throws Exception{
    builder.inMemoryAuthentication()
            .withUser("admin")
            .password((passwordEncoder().encode("admin")))
            .roles("admin");

builder.userDetailsService(userService).passwordEncoder(passwordEncoder());
}
@Override
    protected  void configure(HttpSecurity http) throws Exception{
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/register").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    http.headers().frameOptions().disable();

}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }}