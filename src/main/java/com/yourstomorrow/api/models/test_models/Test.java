package com.yourstomorrow.api.models.test_models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "tests")
public class Test {
  @Id
  @Column(unique = true)
  private String id = UUID.randomUUID().toString().replace("-", "");

  @NotNull(message = "test name cannot be empty or null")
  @Column(unique = true)
  private String name;

  private Integer registeredUsers = 0;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
  private Date startTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
  private Date endTime;

  @JsonIgnore
  private Date createdAt = new Date();

  @JsonIgnore
  public boolean isTestOpen() {
    Date now = new Date();
    return now.before(this.startTime);
  }

}
