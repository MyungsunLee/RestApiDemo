package com.lms.restapidemo.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler({ApiException.class})
  public ResponseEntity<ExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
    return ResponseEntity
      .status(e.getError().getStatus())
      .body(ExceptionEntity.builder()
        .errorCode(e.getError().getCode())
        .errorMessage(e.getError().getMessage())
        .build());
  }

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<ExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
    e.printStackTrace();
    return ResponseEntity
      .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
      .body(ExceptionEntity.builder()
        .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
        .errorMessage(e.getMessage())
        .build());
  }
}
