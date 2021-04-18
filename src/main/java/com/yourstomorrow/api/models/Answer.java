package com.yourstomorrow.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answers")
public class Answer {

  @Id
  @Column(unique = true, nullable = false)
  private String questionId;

  private String answer;

  private Character correctOption;

}
