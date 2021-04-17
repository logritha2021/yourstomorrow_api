package com.yourstomorrow.api.controllers;

import com.yourstomorrow.api.constants.Level;
import com.yourstomorrow.api.models.Question;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  @PostMapping("/question")
  public Question addNewQuesion(@RequestBody Question question) {
    // System.out.println(question.getLevel());
    if (question.getLevel() == Level.MEDIUM) {
      System.out.println("This is medium type question");
    }
    return question;
  }
}
