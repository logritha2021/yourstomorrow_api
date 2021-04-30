package com.yourstomorrow.api.models;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.Nullable;

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
@Table(name = "user_test_stats")
public class UserTestStats {

  @Id
  @Column(unique = true)
  private String id = UUID.randomUUID().toString().replace("-", "");
  private String testId;
  private String userId;

  @JsonIgnore
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
  private Date registeredAt;

  @JsonIgnore
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
  @Nullable
  private Date joinedAt = null;

  @JsonIgnore
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
  @Nullable
  private Date CompletedAt = null;

  private Integer attempted = 0;
  private Integer easyCorrect = 0;
  private Integer mediumCorrect = 0;
  private Integer hardCorrect = 0;

  @Column(columnDefinition = "JSON", name = "subject_correct")
  @Nullable
  @ElementCollection
  private Map<String, Integer> subjectCorrect;
}