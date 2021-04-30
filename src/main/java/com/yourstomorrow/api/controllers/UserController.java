package com.yourstomorrow.api.controllers;

import javax.validation.Valid;

import com.yourstomorrow.api.exceptions.UserNotFoundException;
import com.yourstomorrow.api.models.User;
import com.yourstomorrow.api.models.wrappers.PhoneNumber;
import com.yourstomorrow.api.models.wrappers.Response;
import com.yourstomorrow.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
  public Response<User> createNewUser(@Valid @RequestBody User user) {
    User newuser = userService.createNewUser(user);
    return new Response<>(newuser);
  }

  @PostMapping("/info")
  public Response<User> getUserDetails(@RequestBody PhoneNumber body) {
    User user = userService.getUserDetails(body.getPhone());
    if (user == null) {
      throw new UserNotFoundException();
    }
    return new Response<>(user);
  }

  @PutMapping("/{userId}")
  public Response<User> updateUserDetails(@RequestBody User user, @PathVariable String userId) {
    user.setId(userId);
    User updatedUser = userService.updateUserDetails(user);
    return new Response<>(updatedUser);
  }

  @PostMapping("/register/{testId}")
  public Response<Void> registerForATest(@Valid @RequestBody User user, @PathVariable String testId) {
    userService.regiterForAtest(user.getId(), testId);
    return new Response<>();
  }

}
