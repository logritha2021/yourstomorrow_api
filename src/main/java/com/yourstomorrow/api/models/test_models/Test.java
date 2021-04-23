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

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date date;

  private Integer total = 100;

  private Integer current = 0;

  @JsonIgnore
  private Date createdAt = new Date();

  @JsonIgnore
  public boolean isOpen() {
    if (this.current >= this.total) {
      return false;
    }
    return true;
  }
}
