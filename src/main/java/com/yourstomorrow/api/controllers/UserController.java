package com.yourstomorrow.api.controllers;

import com.yourstomorrow.api.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/user")
  public User createNewUser() {
    User newuser = new User();
    return newuser;
  }
}
