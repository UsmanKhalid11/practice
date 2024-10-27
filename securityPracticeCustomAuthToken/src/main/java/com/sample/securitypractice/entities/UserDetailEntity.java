package com.sample.securitypractice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class UserDetailEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private String authorities;
    private String created;

    public UserDetailEntity(String username, String password, boolean enabled, boolean accountNonExpired, String authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.authorities = authorities;
        this.created = new Date().toInstant().toString();

    }
}
