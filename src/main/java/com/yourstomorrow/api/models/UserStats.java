package com.yourstomorrow.api.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserStats {
  private String userId;
  private String testId;
  private boolean registered;
  private Date startedAt;
  private Date endedAt;
  private Integer totalQuestions;
  private Integer attemptedQuestions;
  private Integer correctAnswers;
}
