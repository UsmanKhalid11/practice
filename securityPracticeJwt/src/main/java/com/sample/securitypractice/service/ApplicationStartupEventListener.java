package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.UserDetailEntity;
import com.sample.securitypractice.reposotory.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationStartupEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private  UserDetailRepo userDetailRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Insert data into the database after the application has started
        insertInitialData();
    }

    private void insertInitialData() {
        // Check if data is already present to avoid duplicates
        if (userDetailRepo.count() == 0) {
            userDetailRepo.save(new UserDetailEntity("new", bCryptPasswordEncoder.encode("asd11"), true, true, "USER"));
            userDetailRepo.save(
                    new UserDetailEntity("new2", bCryptPasswordEncoder.encode("asd14"), true, true, "USER"));
            userDetailRepo.save(
                    new UserDetailEntity("admin", bCryptPasswordEncoder.encode("asd15"), true, true, "ADMIN"));

            System.out.println(userDetailRepo.findAll());

        }
    }
}
