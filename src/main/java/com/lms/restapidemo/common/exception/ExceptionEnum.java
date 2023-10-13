package com.lms.restapidemo.common.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
  RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E01", "요청이 잘못되었습니다"),
  NO_SUCH_DATA_EXCEPTION(HttpStatus.NOT_FOUND, "E011", "요청된 데이터가 이미 삭제되었거나 존재하지 않습니다"),
  ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E02"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E03"),
  URL_NOT_FOUND(HttpStatus.NOT_FOUND,"E04", "요청하신 주소가 존재하지 않습니다"),
  SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다.");
  // NO_DATA_ERROR(HttpStatus., "E05","해당 데이터가 존재하지 않습니다");

  private final HttpStatus status;
  private final String code;
  private String message;

  ExceptionEnum(HttpStatus status, String code) {
    this.status = status;
    this.code = code;
  }

  ExceptionEnum(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}