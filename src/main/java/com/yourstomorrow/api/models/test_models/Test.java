package com.yourstomorrow.api.models.test_models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "tests")
public class Test {
  @Id
  @Column(unique = true)
  private String id = UUID.randomUUID().toString().replace("-", "");

  @NotNull(message = "test name cannot be empty or null")
  @Column(unique = true)
  private String name;

  @NotNull(message = "test date must be a valid date")

  private Integer registeredUsers = 0;

  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date startTime;

  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date endTime;

  @JsonIgnore
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date createdAt = new Date();

}
