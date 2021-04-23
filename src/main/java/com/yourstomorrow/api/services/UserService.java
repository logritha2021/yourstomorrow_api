package com.yourstomorrow.api.services;

import com.yourstomorrow.api.models.test_models.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  TestService testService;

  public boolean joinATest(String testid, String userid) {
    Test test = testService.getTestById(testid);
    if (!test.isOpen()) {
      return false;
    }
    return true;
  }
}
