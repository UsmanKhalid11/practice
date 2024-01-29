package com.example.sprinInAction.Service;

import com.example.sprinInAction.Entity.RegistrationEntity;
import com.example.sprinInAction.Pojo.RegistrationPojo;
import com.example.sprinInAction.RegistrationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RegistartionServiceImpl implements  RegistartionService {
    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public void register(RegistrationPojo registrationPojo){
        RegistrationEntity entity= new RegistrationEntity(registrationPojo);

        registrationRepo.save(entity);
        log.info("registration saved to db");

    }
}
