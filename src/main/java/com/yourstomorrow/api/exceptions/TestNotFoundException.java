package com.yourstomorrow.api.exceptions;

public class TestNotFoundException extends RuntimeException {
  /**
  *
  */
  private static final long serialVersionUID = 4L;

  private String errorMessage = "test does not exist";

  public TestNotFoundException() {
    super();
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
