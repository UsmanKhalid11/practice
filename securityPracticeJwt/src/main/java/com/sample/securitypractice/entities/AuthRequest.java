package com.sample.securitypractice.entities;

import lombok.Data;

@Data
public class AuthRequest {

  private String userName;
  private String password;

}
