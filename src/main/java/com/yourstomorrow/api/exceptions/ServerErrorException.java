package com.yourstomorrow.api.exceptions;

public class ServerErrorException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String errorMessage;

  public ServerErrorException() {
    super();
    this.errorMessage = "INTERVAL_SERVER_ERROR";
  }

  public ServerErrorException(String message) {
    this.errorMessage = message;
  }

  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
