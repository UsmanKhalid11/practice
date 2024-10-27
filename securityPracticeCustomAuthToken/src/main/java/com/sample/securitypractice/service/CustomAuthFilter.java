package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.CustomAuthToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class CustomAuthFilter extends AbstractAuthenticationProcessingFilter {

	public CustomAuthFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl, authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		try {
			String token = request.getHeader("Authorization").split(" ")[1];

			byte[] decodedBytes = Base64.getDecoder().decode(token);
			String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
			String[] credentials = decodedString.split(";");
			String username = credentials[0];
			String password = credentials[1];
			if (credentials.length > 2) {
				String dateTime = credentials[2];

				CustomAuthToken customAuthToken = new CustomAuthToken(username, dateTime, password);
				return this.getAuthenticationManager().authenticate(customAuthToken);
			} else {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						username, password);
				return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
			}
		} catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage());
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authResult) throws IOException, ServletException {

		SecurityContextHolder.getContext().setAuthentication(authResult);
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		chain.doFilter(request, response);
		}
}

