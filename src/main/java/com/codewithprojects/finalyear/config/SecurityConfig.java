package com.codewithprojects.finalyear.config;
import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for stateless JWT-based authentication
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/*","/api/tourney/","/swagger-ui/", "/v3/api-docs/","/api/v1/tournaments","/api/user/*").permitAll()
                        .requestMatchers("/api/bookings/**").hasRole("USER")// Allow unauthenticated access to auth endpoints
                        .requestMatchers("/api/admin/*","/api/manager/","/api/content/*").hasRole("ADMIN") // Restrict ADMIN endpoints
                        .requestMatchers("/api/manager/**").hasRole("MANAGER") // Restrict MANAGER endpoints
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter before UsernamePasswordAuthenticationFilter

        return http.build();
    }
}
