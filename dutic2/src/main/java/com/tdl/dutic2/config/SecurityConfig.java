package com.tdl.dutic2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/public")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2Login(
                        Customizer.withDefaults()
                )
                .logout(
                        logout -> logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout") // Redirige a esta URL después de cerrar sesión
                                .invalidateHttpSession(true) // Invalidar la sesión HTTP
                                .clearAuthentication(true) // Limpiar la autenticación
                                .deleteCookies("JSESSIONID")
                )
                .build();
    }
}
