package com.yourstomorrow.api.services;

import java.util.Date;
import java.util.Optional;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.exceptions.TestEndedException;
import com.yourstomorrow.api.exceptions.TestNotFoundException;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.user_models.User;
import com.yourstomorrow.api.models.user_models.UserTestStats;
import com.yourstomorrow.api.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  IUserRepository userRepository;

  @Autowired
  TestService testService;

  @Autowired
  StatsService statsService;

  public User createNewUser(User user) {
    if (user.getPhone().length() != 10) {
      throw new InvalidDataException("Invalid phone number");
    } else {
      User saveduser = userRepository.save(user);
      return saveduser;
    }
  }

  public User getUserDetails(String phone) {
    if (phone.length() != 10) {
      throw new InvalidDataException("Invalid phone number");
    }
    User user = userRepository.findUserByPhone(phone);
    return user;
  }

  public User updateUserDetails(User user) {
    if (user.getPhone().length() != 10) {
      throw new TestNotFoundException();
    }
    userRepository.updateUserById(user.getName(), user.getPhone(), user.getEmail(), user.getDob(), new Date(),
        user.getId());
    return user;
  }

  public void regiterForAtest(String userId, String testId) {
    Test test = testService.getTestById(testId);
    if (test == null) {
      throw new TestNotFoundException();
    }
    if (!test.isOpen()) {
      throw new TestEndedException();
    }
    UserTestStats stats = statsService.findUserTestStatByUserAndTestId(testId, userId);
    if (stats == null) {
      statsService.createANewUserTestStat(testId, userId);
    }
    return;
  }

  public User getUserById(String userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent())
      return user.get();
    return null;
  }
}
