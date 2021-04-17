package com.yourstomorrow.api.models;

import java.util.ArrayList;
import java.util.List;

import com.yourstomorrow.api.constants.Level;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Question {
  private String qid;
  private String question;
  private List<String> answers = new ArrayList<>(4);
  private Level level;
  private String category;
}
