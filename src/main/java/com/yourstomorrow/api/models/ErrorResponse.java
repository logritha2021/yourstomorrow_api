package com.yourstomorrow.api.models;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

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
public class ErrorResponse implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private HttpStatus status;
  private String error;
  private String message;
}
