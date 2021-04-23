package com.yourstomorrow.api.controllers;

import com.yourstomorrow.api.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping("")
  public User createNewUser() {
    User newuser = new User();
    return newuser;
  }

  @PostMapping("/test/join/{testid}")
  public ResponseEntity<Void> joinATest(@RequestBody User user) {
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
