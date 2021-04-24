package com.yourstomorrow.api.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.Answer;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.Test;
import com.yourstomorrow.api.models.test_models.TestAnswer;
import com.yourstomorrow.api.repository.IAnswerRespository;
import com.yourstomorrow.api.repository.ITestAnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
  @Autowired
  IAnswerRespository answerRespository;

  @Autowired
  ITestAnswerRepository ansRepository;

  @Autowired
  QuestionService questionService;

  public Answer addAnswer(Question question) {
    Character qOption = question.getAnswer();
    if (qOption == null) {
      throw new InvalidDataException("answer field can not be empty");
    }
    Answer answer = new Answer();
    answer.setQuestionId(question.getId());
    answer.setCorrectOption(qOption);
    switch (qOption) {
    case 'a':
      answer.setAnswer(question.getOptionA());
      break;
    case 'b':
      answer.setAnswer(question.getOptionB());
      break;
    case 'c':
      answer.setAnswer(question.getOptionC());
      break;
    case 'd':
      answer.setAnswer(question.getOptionD());
      break;
    default:
      throw new InvalidDataException("invalid answer option.Allowed ['a','b','c','d']");
    }
    // Answer ans = answerRespository.save(answer);
    return answer;
  }

  public boolean addAnswesforATest(String userId, String testId, List<TestAnswer> answers) {
    Set<String> questionIds = new HashSet<>(questionService.getQuestIdsByTest(testId));
    List<TestAnswer> tosave = new ArrayList<>();
    for (TestAnswer answer : answers) {
      if (questionIds.contains(answer.getQuestionId())) {
        answer.setTestId(testId);
        answer.setUserId(userId);
        tosave.add(answer);
      }
    }
    ansRepository.saveAll(tosave);
    return true;
  }
}
