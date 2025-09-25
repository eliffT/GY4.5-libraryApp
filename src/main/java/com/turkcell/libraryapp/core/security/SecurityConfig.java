package com.turkcell.libraryapp.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers( "/swagger-ui.html",
                                        "/swagger-ui/**",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**").permitAll()
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/books/**")
                                .hasAnyAuthority("Book.Read", "ROLE_LIBRARIAN", "ROLE_MEMBER")
                                .requestMatchers(HttpMethod.POST, "/api/v1/books/**")
                                .hasAnyAuthority("Book.Create", "ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/books/**")
                                .hasAnyAuthority("Book.Delete", "ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.PUT,"/api/v1/books/**")
                                .hasAnyAuthority("Book.Update", "ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/reservations/**")
                                .hasAnyAuthority("Reservation.Read", "ROLE_MEMBER","ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/reservations/**")
                                .hasAnyAuthority("Reservation.Create", "ROLE_MEMBER", "ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/reservations/**")
                                .hasAnyAuthority("Reservation.Delete", "ROLE_MEMBER", "ROLE_LIBRARIAN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/reservations/**")
                                .hasAnyAuthority("Reservation.Update", "ROLE_MEMBER", "ROLE_LIBRARIAN")
                                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
