package com.codewithprojects.finalyear.config;

import com.codewithprojects.finalyear.service.UserService;
import com.codewithprojects.finalyear.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = jwtTokenProvider.getJwtFromRequest(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsernameFromJwt(token);

            // Get the user from UserService
            User user = userService.getUserByRollno(username).orElse(null);

            if (user != null) {
                // Convert role to GrantedAuthority (assuming you only have one role per user)
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole()); // Ensure role is a valid authority

                // Create UserDetails with a list of authorities
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                        user.getRollno(), // assuming 'rollno' is the username
                        user.getPassword(), // Ensure you are fetching password here
                        Collections.singletonList(authority) // List of authorities/roles
                );

                // Create an authentication token and set the details
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set authentication in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
