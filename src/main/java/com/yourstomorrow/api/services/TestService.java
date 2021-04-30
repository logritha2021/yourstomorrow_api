package com.yourstomorrow.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.exceptions.TestNotFoundException;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.test_models.TestAnswer;
import com.yourstomorrow.api.repository.ITestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  @Autowired
  ITestRepository testRepository;

  @Autowired
  QuestionService questionService;

  @Autowired
  AnswerService answerService;

  public Test createNewTest(Test test) {
    Date presenDate = new Date();
    if (test.getName().length() == 0) {
      throw new InvalidDataException("test name can not be empty");
    }
    if (!test.getStartTime().after(presenDate)) {
      throw new InvalidDataException("start date can not be before today's date");
    }
    if (!test.getEndTime().after(test.getStartTime())) {
      throw new InvalidDataException("end date can not be before start date");
    }
    testRepository.save(test);
    return test;
  }

  public List<Test> getAllTests() {
    return testRepository.findAll();
  }

  public Test getTestById(String testid) {
    Optional<Test> test = testRepository.findById(testid);
    if (test.isEmpty())
      return null;
    return test.get();
  }

  public void addQuestionsToTest(String testId, List<String> questionIds) {
    Test test = this.getTestById(testId);
    if (test == null) {
      throw new TestNotFoundException();
    } else {
      questionService.addQuestionsToTest(testId, questionIds);
    }
    return;
  }

  public List<Question> getQuestionsOfTest(String testId) {
    Test test = this.getTestById(testId);
    if (test == null) {
      throw new TestNotFoundException();
    }
    List<Question> questions = questionService.getQuestionsOfTest(testId);
    return questions;
  }

  public boolean addAnswesforATest(String userId, String testId, List<TestAnswer> answers) {
    Test test = this.getTestById(testId);
    if (test == null) {
      throw new TestNotFoundException();
    }
    answerService.addAnswesforATest(userId, testId, answers);
    return true;
  }

}
