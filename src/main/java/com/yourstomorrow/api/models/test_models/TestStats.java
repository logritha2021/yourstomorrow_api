package com.yourstomorrow.api.models.test_models;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

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
public class TestStats {
  private String id = UUID.randomUUID().toString().replace("-", "");

  @NotNull(message = "test id can not be null")
  private String testId;

  private Integer easy = 0;

  private Integer medium = 0;

  private Integer hard = 0;

  private Integer totalUsers = 0;

  @Column(columnDefinition = "JSON")
  @Nullable
  @ElementCollection
  private Map<String, Integer> subject;
}
