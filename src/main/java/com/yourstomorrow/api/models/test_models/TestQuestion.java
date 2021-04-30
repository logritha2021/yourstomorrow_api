package com.yourstomorrow.api.models.test_models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yourstomorrow.api.constants.Level;

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
@Entity
@Table(name = "test_questions")
public class TestQuestion {
  @Id
  private String id = UUID.randomUUID().toString().replace("-", "");
  private String testId;
  private String questionId;
  private String subject;
  private Level level;
}
