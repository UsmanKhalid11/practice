package com.sample.securitypractice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    public ApiHitMock apiHitMock;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

     String username=authentication.getName();
     String password=(String )authentication.getCredentials();
     User user=apiHitMock.authMock(username,password);
     if (user==null){
         throw new BadCredentialsException("not valid user");
     }
     return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
