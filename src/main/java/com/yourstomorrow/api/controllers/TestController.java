package com.yourstomorrow.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.wrappers.AddQuestionToTest;
import com.yourstomorrow.api.services.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  @Autowired
  TestService testService;

  @PostMapping("")
  public ResponseEntity<Test> createNewTest(@RequestBody Test test) {
    Test newtest = testService.createNewTest(test);
    return new ResponseEntity<>(newtest, HttpStatus.CREATED);
  }

  @GetMapping("")
  public ResponseEntity<List<Test>> getAllTests() {
    List<Test> alltest = testService.getAllTests();
    if (alltest.size() == 0) {
      return new ResponseEntity<>(alltest, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(alltest, HttpStatus.OK);
  }

  @PostMapping("/question")
  public ResponseEntity<Void> addQuestionsToTest(@RequestBody AddQuestionToTest body) {
    testService.addQuestionsToTest(body.getTestId(), body.getQuestionIds());
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  @GetMapping("/question/{testId}")
  public ResponseEntity<List<Question>> getQuestionsOfTest(@PathVariable String testId) {
    List<Question> qs = testService.getQuestionsOfTest(testId);
    if (qs.size() == 0) {
      return new ResponseEntity<>(qs, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(qs, HttpStatus.OK);
  }

}
