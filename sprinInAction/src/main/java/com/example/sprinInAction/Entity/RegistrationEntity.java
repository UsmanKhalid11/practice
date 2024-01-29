package com.example.sprinInAction.Entity;

import com.example.sprinInAction.Pojo.RegistrationPojo;
import com.example.sprinInAction.Pojo.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contact;

    @Column(name = "role")
    private Role role;
    public RegistrationEntity(RegistrationPojo registrationPojo){
        this.name=registrationPojo.getName();
        this.email=registrationPojo.getEmail();
        this.contact=registrationPojo.getContact();
        this.role=registrationPojo.getRole();

    }
}