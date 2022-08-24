/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.exception;

import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception Handler.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Business Exception handling.
   *
   * @param exception Exception
   * @param request Request
   * @return ResponseEntity
   */
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Object> handleBusinessException(BusinessException exception,
      WebRequest request) {
    logger.error("Exception ", exception);
    return new ResponseEntity<>(exception.getErrorDetail(), exception.getHttpStatus());
  }


  /**
   * Handle NoHandlerFoundException.
   *
   * @param exception Exception
   * @param headers Header
   * @param status Status
   * @param request Request
   */
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    logger.error("Exception ", exception);
    ErrorDetail errorDetail = new ErrorDetail("RESOURCE_NOT_FOUND",
        "The requested resource does not exist or is not supported by this version of the API.");
    return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
  }

  /**
   * MissingServletRequestParameterException.
   *
   * @param exception Exception
   * @param headers Header
   * @param status Status
   * @param request Request
   */
  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException exception,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    logger.error("Exception", exception);
    ErrorDetail errorDetail = new ErrorDetail("SRV_GENERIC_ERROR",
        "Request parameters are not valid:" + exception.getMessage());
    return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException exception,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    String errorText = exception.getBindingResult().getAllErrors()
        .stream()
        .map(error -> {
          String message;
          if (error instanceof FieldError) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            message = "'" + fieldName + "'" + " " + errorMessage;
          } else {
            message = error.getDefaultMessage();
          }
          return message;

        })
        .collect(Collectors.joining("|"));

    logger.error("Exception ", exception);
    ErrorDetail errorDetail = new ErrorDetail("INVALID_INPUT",
        errorText);
    return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
  }




}
