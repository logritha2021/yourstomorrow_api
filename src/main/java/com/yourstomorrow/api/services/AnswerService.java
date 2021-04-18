package com.yourstomorrow.api.services;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.Answer;
import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.repository.IAnswerRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
  @Autowired
  IAnswerRespository answerRespository;

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
}
