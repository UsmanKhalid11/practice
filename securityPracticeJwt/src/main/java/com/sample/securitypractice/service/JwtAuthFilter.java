package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.JwtTokenEntities;
import com.sample.securitypractice.entities.UserDetailEntity;
import com.sample.securitypractice.reposotory.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailRepo userDetailRepo;
	@Autowired
	private JwtRepoService jwtRepoService;
	@Autowired
	private JwtUtilService jwtUtilService;
	private static final List<String> EXCLUDED_PATHS = Arrays.asList(
			"/v1.0/authenticate",
			"/v1.0/jwts"
	);
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws AuthenticationException, IOException, ServletException {
		try {
			String requestPath = request.getRequestURI();
			if (EXCLUDED_PATHS.contains(requestPath)) {
				filterChain.doFilter(request, response);
				return;
			}
			String token = request.getHeader("Authorization").split(" ")[1];
			String userName = jwtUtilService.extractUsername(token);
			Optional<UserDetailEntity> userDetailEntityOptional = userDetailRepo.findByUsername(userName);
			if (userDetailEntityOptional.isPresent()) {
				UserDetailEntity userDetailEntity = userDetailEntityOptional.get();
				JwtTokenEntities jwtTokenEntities=jwtRepoService.getByName(userName);
				if (!jwtTokenEntities.isExpired()) {
					SecurityContextHolder.getContext()
							.setAuthentication(new UsernamePasswordAuthenticationToken(userDetailEntity.getUsername(),
									userDetailEntity.getPassword(), Collections.singleton(
									new SimpleGrantedAuthority(userDetailEntity.getAuthorities()))));
					filterChain.doFilter(request, response);

				} else {

					filterChain.doFilter(request, response);
					throw new RuntimeException("Token expired");
				}
			} else {

				filterChain.doFilter(request, response);
				throw new RuntimeException("User not found");
			}

		} catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage());
		}

	}

}

