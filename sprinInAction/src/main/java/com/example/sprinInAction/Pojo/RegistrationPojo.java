package com.example.sprinInAction.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
public class RegistrationPojo {


    @NotEmpty(message = "Name may not be empty")
    private String name;
    @Email
    @NotEmpty(message = "Email may not be empty")
    private String email;
    @NotEmpty(message = "Contact may not be empty")
    private String contact;
    @NotEmpty(message = "Role cannot be empty")
    private Role role;
    @NotEmpty(message = "Role cannot be empty")
    private String password;
}