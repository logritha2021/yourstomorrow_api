package com.yourstomorrow.api.controllers;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.exceptions.ServerErrorException;
import com.yourstomorrow.api.exceptions.TestNotFoundException;
import com.yourstomorrow.api.exceptions.UnauthorizedUserException;
import com.yourstomorrow.api.exceptions.UserNotFoundException;
import com.yourstomorrow.api.models.ErrorResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

  static final String failed = "failed";

  @ExceptionHandler(InvalidDataException.class)
  public final ResponseEntity<ErrorResponse> invalidData(InvalidDataException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(ex.getMessage());
    error.setStatus(failed);
    error.setPayload("BAD_REQUEST");
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  @ExceptionHandler(UnauthorizedUserException.class)
  public final ResponseEntity<Void> unauthorized(InvalidDataException ex, WebRequest request) {
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public final ResponseEntity<ErrorResponse> dataIntegrity(DataIntegrityViolationException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(ex.getMessage());
    error.setStatus(failed);
    error.setPayload("BAD_REQUEST");
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  @ExceptionHandler(ServerErrorException.class)
  public final ResponseEntity<ErrorResponse> serverError(ServerErrorException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(ex.getMessage());
    error.setStatus(failed);
    error.setPayload("INTERNAL_SERVER_ERROR");
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<ErrorResponse> userNotFound(UserNotFoundException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(ex.getMessage());
    error.setStatus(failed);
    error.setPayload("NOT_FOUND");
    return new ResponseEntity<>(error, HttpStatus.OK);
  }

  @ExceptionHandler(TestNotFoundException.class)
  public final ResponseEntity<ErrorResponse> testNotFound(TestNotFoundException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setMessage(ex.getMessage());
    error.setStatus(failed);
    error.setPayload("NOT_FOUND");
    return new ResponseEntity<>(error, HttpStatus.OK);
  }
}
