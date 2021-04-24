package com.yourstomorrow.api.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yourstomorrow.api.models.Question;
import com.yourstomorrow.api.models.test_models.TestQuestion;
import com.yourstomorrow.api.repository.IQuestionRepository;
import com.yourstomorrow.api.repository.ITestQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  @Autowired
  IQuestionRepository questionRepository;

  @Autowired
  AnswerService answerService;

  @Autowired
  ITestQuestionRepository tqRepository;

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

  public List<String> getQuestIdsByTest(String testId) {
    List<String> questionIds = tqRepository.findByQuestionId(testId);
    return questionIds;
  }

  public void addQuestionsToTest(String testId, List<String> questionIds) {
    Set<String> presentQids = new HashSet<>(this.getQuestIdsByTest(testId));
    List<Question> fullQuestion = this.getQuestionsByIds(questionIds);
    List<TestQuestion> tosave = new ArrayList<>(questionIds.size());
    for (Question question : fullQuestion) {
      if (!presentQids.contains(question.getId())) {
        TestQuestion temp = new TestQuestion();
        temp.setQuestionId(question.getId());
        temp.setTestId(testId);
        temp.setLevel(question.getLevel());
        temp.setSubject(question.getSubject());
        tosave.add(temp);
      }
    }
    tqRepository.saveAll(tosave);
  }

  public List<Question> getQuestionsOfTest(String testId) {
    List<String> questionIds = this.getQuestIdsByTest(testId);
    List<Question> questions = this.getQuestionsByIds(questionIds);
    return questions;
  }
}