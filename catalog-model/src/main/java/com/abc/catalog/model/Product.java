/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@JsonDeserialize(builder = Product.ProductBuilder.class)
public class Product {

  private final String id;

  @NotNull
  private final String name;

  @NotBlank(message = "Please add a value")
  private final String barcode;

  @JsonPOJOBuilder(withPrefix = "")
  public static class ProductBuilder {
    //intentionally empty
  }

}
