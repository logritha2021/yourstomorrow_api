package com.yourstomorrow.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @PostMapping("/question")
  public ResponseEntity<Question> addNewQuesion(@Valid @RequestBody Question question) {
    Question savedQuestion = questionService.addNewQuestion(question);
    // System.out.println("Question saved to database " + savedQuestion.toString());
    return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
  }

  @GetMapping("/question")
  public ResponseEntity<List<Question>> getQuestions() {
    List<Question> qs = questionService.getQuestions();
    return new ResponseEntity<>(qs, qs.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
  }

}
