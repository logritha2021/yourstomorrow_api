package com.yourstomorrow.api.models.test_models;

import java.util.UUID;

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
@Entity(name = "test_questions")
public class TestQuestion {
  @Id
  private String id = UUID.randomUUID().toString().replace("-", "");
  private String testId;
  private String questionId;
}
