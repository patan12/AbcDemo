/*
 * Copyright (c) 2018 JCPenney Co. All rights reserved.
 */

package com.abc.catalog.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Error Codes , Status and Messages.
 */
@Getter
public enum ErrorCode {
  PRODUCT_NOT_FOUND("Product not found", HttpStatus.NOT_FOUND),

  ;

  private final String message;
  private final HttpStatus httpStatus;

  ErrorCode(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

}