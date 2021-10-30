package org.lucas.alkemy.challenge;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lucas.alkemy.challenge.user.AppUserDetailsService;
import org.lucas.alkemy.challenge.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		String username = null;
		String token = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			username = jwtUtils.extractUsername(token);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = appUserDetailsService.loadUserByUsername(username);

			if (!jwtUtils.isTokenExpired(token) == true) {

				var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());

				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
		}

		filterChain.doFilter(request, response);
	}

}
