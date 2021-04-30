package com.yourstomorrow.api.services;

import java.util.Date;

import com.yourstomorrow.api.models.UserTestStats;
import com.yourstomorrow.api.repository.IUserTestStatRepostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestStatsService {
  @Autowired
  IUserTestStatRepostory repo;

  public UserTestStats findStatByUserAndTestId(String testId, String userId) {
    return repo.findStatByUserAndTestId(testId, userId);
  }

  public UserTestStats createNewStat(String testId, String userId) {
    UserTestStats newstat = new UserTestStats();
    newstat.setRegisteredAt(new Date());
    return repo.save(newstat);
  }
}
