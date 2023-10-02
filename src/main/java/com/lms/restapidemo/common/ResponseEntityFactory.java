package com.lms.restapidemo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory {
  public static <T> ResponseEntity make(T response) {
    return new ResponseEntity(response, HttpStatus.OK);
  }
}
