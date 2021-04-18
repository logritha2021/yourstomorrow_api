package com.yourstomorrow.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
  private String userid;
  private String username;
  private String phone;
  private String email;
  private String dob;
}
