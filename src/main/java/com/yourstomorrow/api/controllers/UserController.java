package com.yourstomorrow.api.controllers;

import javax.validation.Valid;

import com.yourstomorrow.api.models.User;
import com.yourstomorrow.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUserDetails(@PathVariable String userId) {
    User user = userService.getUserDetails(userId);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<User> updateUserDetails(@RequestBody User user, @PathVariable String userId) {
    user.setId(userId);
    User updatedUser = userService.updateUserDetails(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

}
