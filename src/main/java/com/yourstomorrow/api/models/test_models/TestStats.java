package com.yourstomorrow.api.models.test_models;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

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
@Entity
@Table(name = "test_stats")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class TestStats implements Serializable {

  @Id
  @NotNull(message = "test id can not be null")
  private String testId;

  private Integer easy = 0;

  private Integer medium = 0;

  private Integer hard = 0;

  private Integer totalQuestions = 0;

  @Type(type = "json")
  @Column(columnDefinition = "json")
  private Map<String, Integer> subject;
}
