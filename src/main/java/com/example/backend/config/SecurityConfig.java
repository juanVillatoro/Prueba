package com.example.backend.config;

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
        http.csrf().disable()  // Deshabilitar CSRF (dependiendo de tus necesidades)
            .authorizeRequests()
                .requestMatchers("/login", "/register", "/api/users").permitAll()  // Permitir acceso público a algunas rutas
                .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
            .and()
            .formLogin()
                .loginPage("/login")  // Página personalizada de login
                .permitAll()  // Permitir que todos accedan a la página de login
            .and()
            .logout()
                .permitAll();  // Permitir logout público

        return http.build();
    }
}
