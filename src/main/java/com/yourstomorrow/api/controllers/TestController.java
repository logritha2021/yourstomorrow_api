package com.yourstomorrow.api.controllers;

import java.util.List;

import com.yourstomorrow.api.exceptions.ServerErrorException;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.test_models.TestAnswer;
import com.yourstomorrow.api.models.wrappers.AddQuestionToTest;
import com.yourstomorrow.api.models.wrappers.Response;
import com.yourstomorrow.api.services.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  @Autowired
  TestService testService;

  @PostMapping("")
  public Response<Test> createNewTest(@RequestBody Test test) {
    Test newtest = testService.createNewTest(test);
    return new Response<>(newtest);
  }

  @GetMapping("")
  public Response<List<Test>> getAllTests() {
    List<Test> alltest = testService.getAllTests();
    return new Response<>(alltest);
  }

  @PostMapping("/question")
  public Response<Void> addQuestionsToTest(@RequestBody AddQuestionToTest body) {
    testService.addQuestionsToTest(body.getTestId(), body.getQuestionIds());
    return new Response<>();
  }

  @GetMapping("/question/{testId}")
  public Response<List<Question>> getQuestionsOfTest(@PathVariable String testId) {
    List<Question> qs = testService.getQuestionsOfTest(testId);
    return new Response<>(qs);
  }

  @PostMapping("/answer/{testId}")
  public Response<Void> updateAnswers(@PathVariable String testId, @RequestBody List<TestAnswer> answers,
      @RequestHeader("x_auth_id") String userId) {
    boolean isAdded = testService.addAnswesforATest(userId, testId, answers);
    if (!isAdded) {
      throw new ServerErrorException("answer not added.please retry");
    }
    return new Response<>();
  }

}
