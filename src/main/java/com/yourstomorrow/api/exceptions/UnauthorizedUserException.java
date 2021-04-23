package com.yourstomorrow.api.exceptions;

public class UnauthorizedUserException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String errorMessage;

  public UnauthorizedUserException() {
    super();
    this.errorMessage = "Unauthorized request";
  }

  public UnauthorizedUserException(String message) {
    this.errorMessage = message;
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
