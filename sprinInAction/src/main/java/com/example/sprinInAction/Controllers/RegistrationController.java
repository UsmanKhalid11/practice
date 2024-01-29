package com.example.sprinInAction.Controllers;

import com.example.sprinInAction.Pojo.RegistrationPojo;
import com.example.sprinInAction.Service.RegistartionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistartionService registartionService;

    @PostMapping
    public void register(@Valid @RequestBody RegistrationPojo registrationPojo){
        registartionService.register(registrationPojo);

    }

}
