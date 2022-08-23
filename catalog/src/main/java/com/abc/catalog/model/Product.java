/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder(toBuilder = true)
public class Product {

  private final String id;
  @NotNull
  private final String name;
  @NotBlank(message = "Please add a value")
  private final String barcode;
}
