package com.yourstomorrow.api.controllers;

import java.util.List;

import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.services.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
