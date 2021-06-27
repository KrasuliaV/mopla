package com.cursor.mopla.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserSecurityServiceImpl userService;
    private final JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        final String authorisationHeader = request.getHeader("Authorization");

        String username = null;

        String jwt = null;

        if (authorisationHeader != null && authorisationHeader.startsWith("Bearer ")) {
            jwt = authorisationHeader.substring(7);
            username = jwtTokenUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = this.userService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwt, userDetails)) {

                var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, username, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }
}
