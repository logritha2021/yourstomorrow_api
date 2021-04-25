package com.yourstomorrow.api.models.wrappers;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ResponseStatus(HttpStatus.OK)
public class Response<T> implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 2L;

  String status;
  T payload;
  String message = "";

  public Response() {
    this.status = "success";
  }

  public Response(T payload) {
    this.status = "success";
    this.payload = payload;
  }

  public Response(T payload, String status) {
    this.status = status;
    this.payload = payload;
  }

  public Response(T payload, String status, String message) {
    this.status = status;
    this.payload = payload;
    this.message = "";
  }
}
