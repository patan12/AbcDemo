/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.exception;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representation of Error Detail.
 */

@AllArgsConstructor
public class ErrorDetail implements Serializable {

  private static final long serialVersionUID = 2405172041950251807L;

  @Getter
  private final String errorCode;

  @Getter
  private final String errorMessage;

}
