/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Error Codes , Status and Messages.
 */
@Getter
public enum ErrorCode {
  PRODUCT_NOT_FOUND("Product not found", HttpStatus.NOT_FOUND),
  PRODUCT_ALREADY_EXIST("Product Already Exist found", HttpStatus.CONFLICT),

  ;

  private final String message;
  private final HttpStatus httpStatus;

  ErrorCode(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

}