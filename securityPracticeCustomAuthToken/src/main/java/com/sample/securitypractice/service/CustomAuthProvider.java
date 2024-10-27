package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.CustomAuthToken;
import com.sample.securitypractice.entities.UserDetailEntity;
import com.sample.securitypractice.reposotory.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class CustomAuthProvider implements AuthenticationProvider {
	@Autowired
	private MyDbUserDetailService myDbUserDetailService;
	@Lazy
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getPrincipal().toString();
		String credentials = (String) authentication.getCredentials();
		UserDetailEntity userDetails = myDbUserDetailService.getAuthCredForCustomToken(username);
		if (authentication instanceof CustomAuthToken) {
			String password = ((CustomAuthToken) authentication).getPassword();
			if (validateToken(userDetails, password, credentials)) {

				CustomAuthToken customAuthToken = new CustomAuthToken(
						Collections.singleton(new SimpleGrantedAuthority(userDetails.getAuthorities())),
						userDetails.getUsername(), userDetails.getCreated(), userDetails.getPassword());
				return customAuthToken;
			}
			else {
				throw new AuthenticationException("Invalid token") {
				};
			}
		} else if (authentication instanceof UsernamePasswordAuthenticationToken) {
			if (validateTokenUserNameAuthToken(userDetails, credentials)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword(),
						Collections.singleton(new SimpleGrantedAuthority(userDetails.getAuthorities())));
				return usernamePasswordAuthenticationToken;

			}
			else {
				throw new AuthenticationException("Invalid token") {
				};
			}
		}
		else {
			throw new AuthenticationException("Invalid token") {
			};
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return CustomAuthToken.class.isAssignableFrom(authentication)
				|| UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	private boolean validateToken(UserDetailEntity userDetails, String password, String dateTime) {
		return bCryptPasswordEncoder.matches(password, userDetails.getPassword()) && userDetails.getCreated()
				.equals(dateTime);
	}

	private boolean validateTokenUserNameAuthToken(UserDetailEntity userDetails, String password) {
		return bCryptPasswordEncoder.matches(password, userDetails.getPassword());
	}
}
