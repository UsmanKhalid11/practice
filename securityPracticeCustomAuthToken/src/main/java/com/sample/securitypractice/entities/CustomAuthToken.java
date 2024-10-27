package com.sample.securitypractice.entities;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthToken extends AbstractAuthenticationToken {
	private Object principal;
	private Object credentials;
	private String password;

	public CustomAuthToken(Object principal, Object credentials, String password) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		this.password = password;
		super.setAuthenticated(false);
	}

	public CustomAuthToken(Collection<? extends GrantedAuthority> authorities, Object principal, Object credentials,
			String password) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		this.password = password;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
	public String getPassword(){
		 return this.password;
	}
}
