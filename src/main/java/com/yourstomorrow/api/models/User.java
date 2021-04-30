package com.yourstomorrow.api.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(unique = true)
  private String id = UUID.randomUUID().toString().replace("-", "");

  @NotNull(message = "username cannot be empty")
  @Length(min = 3, message = "username should be minimum of three letters")
  private String name;

  @NotNull(message = "phone number cannot be empty")
  @Column(unique = true)
  private String phone;

  private String email;

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date of birth cannot be empty")
  private Date dob;

  @JsonIgnore
  private Date updatedAt = new Date();
}
