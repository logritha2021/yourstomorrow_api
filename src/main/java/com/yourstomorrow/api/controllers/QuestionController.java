package com.yourstomorrow.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
  }

  @GetMapping("/question")
  public ResponseEntity<List<Question>> getQuestions() {
    List<Question> qs = questionService.getQuestions();
    if (qs.size() == 0) {
      return new ResponseEntity<>(qs, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(qs, HttpStatus.OK);
  }

  @GetMapping("/question/{subjectName}")
  public ResponseEntity<List<Question>> getQuestionsBySubject(@PathVariable String subjectName) {
    List<Question> qs = questionService.getQuestionsBySubjectName(subjectName);
    if (qs.size() == 0) {
      return new ResponseEntity<>(qs, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(qs, HttpStatus.OK);
  }

}
