package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.UserDetailEntity;
import com.sample.securitypractice.reposotory.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyDbUserDetailService  implements UserDetailsService {


    @Autowired
    private UserDetailRepo userDetailRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDetailEntity> userDetailsOptional = userDetailRepo.findByUsername(s);
        UserDetailEntity userDetailsEntity = userDetailsOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.withUsername(userDetailsEntity.getUsername()).password(userDetailsEntity.getPassword()).roles("USER").build();
    }
}
