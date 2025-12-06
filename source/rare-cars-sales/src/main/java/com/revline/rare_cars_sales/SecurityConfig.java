package com.revline.rare_cars_sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll() // Allow public access to login/register
                        .anyRequest().authenticated() // Require login for everything else
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Use our custom controller endpoint
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}