package com.yourstomorrow.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.yourstomorrow.api.constants.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

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
@Entity(name = "questions")
public class Question {

  @Id
  @Column(unique = true, name = "id", nullable = false)
  private String id = UUID.randomUUID().toString().replace("-", "");

  @NotNull(message = "question can not be empty")
  private String question;

  @NotNull(message = "optionA can not be empty")
  @Column(name = "option_a")
  private String optionA;

  @NotNull(message = "optionB can not be empty")
  @Column(name = "option_b")
  private String optionB;

  @Column(name = "option_c")
  private String optionC;

  @Column(name = "option_d")
  private String optionD;

  private Level level;

  private String subject;

  private String image;

  @JsonProperty(access = Access.WRITE_ONLY)
  @Transient
  private Character answer;

  @JsonIgnore
  public List<String> getOptions() {
    List<String> options = new ArrayList<>();
    options.add(this.optionA);
    options.add(this.optionB);
    options.add(this.optionC);
    options.add(this.optionD);
    return options;
  }

}
