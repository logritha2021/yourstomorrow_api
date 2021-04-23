package com.yourstomorrow.api.controllers;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.exceptions.UnauthorizedUserException;
import com.yourstomorrow.api.models.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidDataException.class)
  public final ResponseEntity<ErrorResponse> invalidData(InvalidDataException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST);
    error.setMessage(ex.getMessage());
    error.setError("BAD_REQUEST");
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UnauthorizedUserException.class)
  public final ResponseEntity<ErrorResponse> unauthorized(InvalidDataException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.UNAUTHORIZED);
    error.setMessage(ex.getMessage());
    error.setError("UNAUTHORIZED");
    return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(NullPointerException.class)
  public final ResponseEntity<ErrorResponse> nullPointer(NullPointerException ex, WebRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    error.setMessage("Null pointer exception");
    error.setError("INTERNAL_SERVER_ERROR");
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
