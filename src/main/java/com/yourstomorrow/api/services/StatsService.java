package com.yourstomorrow.api.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.yourstomorrow.api.constants.Level;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.TestStats;
import com.yourstomorrow.api.models.user_models.UserTestStats;
import com.yourstomorrow.api.repository.ITestStatRepository;
import com.yourstomorrow.api.repository.IUserTestStatRepostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
  @Autowired
  QuestionService questionService;

  @Autowired
  ITestStatRepository testStatrepository;

  @Autowired
  IUserTestStatRepostory userTestStatRepostory;

  public TestStats createStatForATest(String testId) {
    TestStats stats = new TestStats();
    stats.setTestId(testId);
    List<Question> questions = questionService.getQuestionsOfTest(testId);
    stats.setTotalQuestions(questions.size());
    Integer easy, medium, hard;
    easy = medium = hard = 0;
    Map<String, Integer> map = new HashMap<>();
    for (Question question : questions) {
      if (question.getLevel() == Level.EASY) {
        easy += 1;
      }
      if (question.getLevel() == Level.MEDIUM) {
        medium += 1;
      }
      if (question.getLevel() == Level.HARD) {
        hard += 1;
      }
      String subject = question.getSubject();
      if (map.containsKey(subject)) {
        map.put(subject, map.get(subject) + 1);
      } else {
        map.put(subject, 1);
      }
    }
    stats.setEasy(easy);
    stats.setMedium(medium);
    stats.setHard(hard);
    stats.setSubject(map);
    TestStats savedStat = testStatrepository.save(stats);
    return savedStat;
  }

  public TestStats findATestStat(String testId) {
    Optional<TestStats> teststat = testStatrepository.findById(testId);
    if (teststat.isPresent())
      return teststat.get();
    return null;
  }

  public UserTestStats findUserTestStatByUserAndTestId(String testId, String userId) {
    return userTestStatRepostory.findStatByUserAndTestId(testId, userId);
  }

  public UserTestStats createANewUserTestStat(String testId, String userId) {
    UserTestStats newstat = new UserTestStats();
    newstat.setRegisteredAt(new Date());
    newstat.setTestId(testId);
    newstat.setUserId(userId);
    return userTestStatRepostory.save(newstat);
  }

}
