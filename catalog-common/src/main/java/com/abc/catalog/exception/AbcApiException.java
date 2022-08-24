/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.exception;

import com.abc.catalog.model.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * AbcApiException.
 */
public class AbcApiException extends BusinessException {

  private static final long serialVersionUID = -6177939907218052963L;

  public AbcApiException(ErrorCode errorCode) {
    super(errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage());
  }

  public AbcApiException(ErrorCode errorCode, String customMessage) {
    super(errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage(), customMessage);
  }

  public AbcApiException(Throwable cause, ErrorCode errorCode) {
    super(cause, errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage());
  }

  public AbcApiException(HttpStatus httpStatus, String name, String message) {
    super(httpStatus, name, message);
  }

  public AbcApiException(HttpStatus httpStatus, String name, String message,
      Throwable cause) {
    super(cause, httpStatus, name, message);
  }

  public static final AbcApiException ofMessage(ErrorCode errorCode, String message) {
    return new AbcApiException(errorCode.getHttpStatus(), errorCode.name(), message);
  }

  public static final AbcApiException ofMessage(ErrorCode errorCode, String message,
      Throwable cause) {
    return new AbcApiException(errorCode.getHttpStatus(), errorCode.name(), message,
        cause);
  }

}
