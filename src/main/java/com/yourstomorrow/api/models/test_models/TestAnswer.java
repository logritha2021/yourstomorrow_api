package com.yourstomorrow.api.models.test_models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "test_answers")
public class TestAnswer {
  @Id
  private String id = UUID.randomUUID().toString().replace("-", "");
  private String userId;
  private String questionId;
  private String testId;
  private String answer;

  @JsonIgnore
  private Date updatedAt = new Date();
}
