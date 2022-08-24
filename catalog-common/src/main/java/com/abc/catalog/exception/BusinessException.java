/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Business Exception.
 */
public abstract class BusinessException extends RuntimeException {

  private static final long serialVersionUID = -3620870499647924832L;

  @Getter
  private final HttpStatus httpStatus;

  @Getter
  private final ErrorDetail errorDetail;

  /**
   * Creates business exception.
   *
   * @param httpStatus HTTP response status
   * @param errorCode error code to display in response
   * @param errorMessage error message to display in response
   */
  public BusinessException(HttpStatus httpStatus, String errorCode, String errorMessage) {
    super(errorMessage);
    this.httpStatus = httpStatus;
    this.errorDetail = new ErrorDetail(errorCode, errorMessage);
  }

  /**
   * Creates business exception.
   *
   * @param httpStatus HTTP response status
   * @param errorCode error code to display in response
   * @param errorMessage error message to display in response
   * @param customMessage Custom message that can be appended in log
   */
  public BusinessException(HttpStatus httpStatus, String errorCode, String errorMessage,
      String customMessage) {
    super(errorMessage + " " + customMessage);
    this.httpStatus = httpStatus;
    this.errorDetail = new ErrorDetail(errorCode, errorMessage);
  }

  /**
   * Creates business exception.
   *
   * @param httpStatus HTTP response status
   * @param errorCode error code to display in response
   * @param errorMessage error message to display in response
   * @param customMessage Custom message that can be appended in log
   */
  public BusinessException(HttpStatus httpStatus, String errorCode, String errorMessage,
      String customMessage, Throwable cause) {
    super(errorMessage + " " + customMessage, cause);
    this.httpStatus = httpStatus;
    this.errorDetail = new ErrorDetail(errorCode, errorMessage);
  }


  /**
   * Creates business exception.
   *
   * @param cause parent cause of this exception
   * @param httpStatus HTTP response status
   * @param errorCode error code to display in response
   * @param errorMessage error message to display in response
   */
  public BusinessException(Throwable cause,
      HttpStatus httpStatus, String errorCode, String errorMessage) {
    super(errorMessage, cause);
    this.httpStatus = httpStatus;
    this.errorDetail = new ErrorDetail(errorCode, errorMessage);
  }


}
