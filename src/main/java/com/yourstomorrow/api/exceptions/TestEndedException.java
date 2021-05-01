package com.yourstomorrow.api.exceptions;

public class TestEndedException extends RuntimeException {
  /**
  *
  */
  private static final long serialVersionUID = 5L;

  private String errorMessage = "test already ended";

  public TestEndedException() {
    super();
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
