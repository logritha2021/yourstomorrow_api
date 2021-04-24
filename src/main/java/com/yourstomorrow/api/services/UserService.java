package com.yourstomorrow.api.services;

import java.util.Date;
import java.util.Optional;

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

  public User getUserDetails(String userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isEmpty())
      return null;
    return user.get();
  }

  public User updateUserDetails(User user) {
    userRepository.updateUserById(user.getName(), user.getPhone(), user.getEmail(), user.getDob(), new Date(),
        user.getId());
    return user;
  }
}
