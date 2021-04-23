package com.yourstomorrow.api.services;

import java.util.Date;
import java.util.List;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.repository.ITestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  @Autowired
  ITestRepository testRepository;

  public Test createNewTest(Test test) {
    Date presenDate = new Date();
    if (!test.getDate().after(presenDate)) {
      throw new InvalidDataException("test data can not be before today's date");
    }
    // System.out.println(test.toString());
    testRepository.save(test);
    return test;
  }

  public List<Test> getAllTests() {
    return testRepository.findAll();
  }

  public Test getTestById(String testid) {
    Test test = testRepository.getOne(testid);
    if (test == null) {
      throw new InvalidDataException("test does not exist");
    }
    return test;
  }
}
