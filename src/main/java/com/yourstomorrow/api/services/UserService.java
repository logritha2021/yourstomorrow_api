package com.yourstomorrow.api.services;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.User;
import com.yourstomorrow.api.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  IUserRepository userRepository;

  public User createNewUser(User user) {
    if (user.getPhone().length() != 10) {
      throw new InvalidDataException("Invalid phone number");
    } else {
      User saveduser = userRepository.save(user);
      return saveduser;
    }
  }
}
