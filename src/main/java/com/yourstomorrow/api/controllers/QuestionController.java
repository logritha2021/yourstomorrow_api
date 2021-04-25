package com.yourstomorrow.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.wrappers.Response;
import com.yourstomorrow.api.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
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
  public Response<Question> addNewQuesion(@Valid @RequestBody Question question) {
    Question savedQuestion = questionService.addNewQuestion(question);
    return new Response<>(savedQuestion);
  }

  @GetMapping("/question")
  public Response<List<Question>> getQuestions() {
    List<Question> qs = questionService.getQuestions();
    return new Response<>(qs);
  }

  @GetMapping("/question/{subjectName}")
  public Response<List<Question>> getQuestionsBySubject(@PathVariable String subjectName) {
    List<Question> qs = questionService.getQuestionsBySubjectName(subjectName);
    return new Response<>(qs);
  }

}
