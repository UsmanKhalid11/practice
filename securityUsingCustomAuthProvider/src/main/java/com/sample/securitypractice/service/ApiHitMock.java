package com.sample.securitypractice.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ApiHitMock {


    public User authMock(String userName, String password) {
        List<Map<String, Map<String, String>>> users = List.of(
                Map.of("user1", Map.of("password", "abc1", "roles", "user")),
                Map.of("user2", Map.of("password", "abc2", "roles", "user")),
                Map.of("admin", Map.of("password", "admin", "roles", "admin"))
        );


        Optional<User> optionalUser = users.stream()
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> entry.getKey().equals(userName) && entry.getValue().get("password").equals(password))
                .map(entry -> {
                    String role = entry.getValue().get("roles");
                    Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
                    return new User(entry.getKey(), entry.getValue().get("password"), authorities);
                })
                .findFirst();

        return optionalUser.orElse(null);
    }

}
