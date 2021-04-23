package com.yourstomorrow.api.controllers;

import javax.validation.Valid;

import com.yourstomorrow.api.models.User;
import com.yourstomorrow.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("")
  public ResponseEntity<User> createNewUser(@Valid @RequestBody User user) {
    User newuser = userService.createNewUser(user);
    return new ResponseEntity<>(newuser, HttpStatus.CREATED);
  }

  @PostMapping("/test/join/{testid}")
  public ResponseEntity<Void> joinATest(@RequestBody User user) {
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }
}
