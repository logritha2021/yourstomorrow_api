package com.yourstomorrow.api.exceptions;

public class InvalidDataException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String errorMessage;

  public InvalidDataException() {
    super();
    this.errorMessage = "Something went wrong";
  }

  public InvalidDataException(String message) {
    this.errorMessage = message;
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }

}
