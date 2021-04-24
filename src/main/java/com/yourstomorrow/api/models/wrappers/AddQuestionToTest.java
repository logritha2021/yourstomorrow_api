package com.yourstomorrow.api.models.wrappers;

import java.util.List;

import com.yourstomorrow.api.models.test_models.TestQuestion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddQuestionToTest {
  private String testId;
  private List<TestQuestion> questions;
}
