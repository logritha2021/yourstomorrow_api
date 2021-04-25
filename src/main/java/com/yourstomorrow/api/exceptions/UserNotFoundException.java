package com.yourstomorrow.api.exceptions;

public class UserNotFoundException extends RuntimeException {
  /**
  *
  */
  private static final long serialVersionUID = 4L;

  private String errorMessage = "user does not exist";

  public UserNotFoundException() {
    super();
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
