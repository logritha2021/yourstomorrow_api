package com.yourstomorrow.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.test_models.TestQuestion;
import com.yourstomorrow.api.repository.ITestQuestionRepository;
import com.yourstomorrow.api.repository.ITestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  @Autowired
  ITestRepository testRepository;

  @Autowired
  ITestQuestionRepository tqRepository;

  @Autowired
  QuestionService questionService;

  public Test createNewTest(Test test) {
    Date presenDate = new Date();
    if (!test.getDate().after(presenDate)) {
      throw new InvalidDataException("test data can not be before today's date");
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

  public List<String> getQuestIdsByTest(String testId) {
    List<String> questionIds = tqRepository.findByQuestionId(testId);
    return questionIds;
  }

  public void addQuestionsToTest(String testId, List<String> questionIds) {
    Test test = this.getTestById(testId);
    if (test == null) {
      throw new InvalidDataException("test id does not exist");
    } else {
      Set<String> presentQids = new HashSet<>(this.getQuestIdsByTest(testId));
      List<TestQuestion> tosave = new ArrayList<>(questionIds.size());
      for (String qId : questionIds) {
        if (!presentQids.contains(qId)) {
          TestQuestion temp = new TestQuestion();
          temp.setQuestionId(qId);
          temp.setTestId(testId);
          tosave.add(temp);
        }
      }
      tqRepository.saveAll(tosave);
    }
    return;
  }

  public List<Question> getQuestionsOfTest(String testId) {
    Test test = this.getTestById(testId);
    if (test == null) {
      throw new InvalidDataException("test id does not exist");
    }
    List<String> questionIds = this.getQuestIdsByTest(testId);
    List<Question> questions = questionService.getQuestionsByIds(questionIds);
    return questions;
  }
}
