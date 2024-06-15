package com.aluracursos.challengeForohub.security;
import com.aluracursos.challengeForohub.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final TokenService tokenService;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(TokenService tokenService, UserDetailsService userDetailsService) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF solo para propósitos de desarrollo
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/topics/**").authenticated()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager, tokenService, userDetailsService), UsernamePasswordAuthenticationFilter.class)
                .httpBasic(withDefaults()); // Usar withDefaults() en lugar de httpBasic()
        return http.build();
    }
}