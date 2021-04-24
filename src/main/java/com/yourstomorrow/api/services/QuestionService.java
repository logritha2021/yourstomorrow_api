package com.yourstomorrow.api.services;

import java.util.List;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  @Autowired
  IQuestionRepository questionRepository;

  @Autowired
  AnswerService answerService;

  public Question addNewQuestion(Question question) {
    if (question.getId() == null) {
      Question temp = new Question();
      question.setId(temp.getId());
    }
    answerService.addAnswer(question);
    // questionRepository.save(question);
    return question;
  }

  public List<Question> getQuestions() {
    List<Question> qs = questionRepository.findAll();
    return qs;
  }

  public List<Question> getQuestionsByIds(List<String> questionIds) {
    List<Question> qs = questionRepository.findAllById(questionIds);
    return qs;
  }

  public List<Question> getQuestionsBySubjectName(String subjectName) {
    List<Question> qs = questionRepository.findQuestionsBySubjectName(subjectName);
    return qs;
  }
}