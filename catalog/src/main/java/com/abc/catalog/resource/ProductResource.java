/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.resource;

import static com.abc.catalog.error.ErrorCode.PRODUCT_NOT_FOUND;

import com.abc.catalog.exception.AbcApiException;
import com.abc.catalog.model.Product;
import com.abc.catalog.utils.ProductUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductResource {

  public static void main(String[] args) {
    SpringApplication.run(ProductResource.class, args);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable final String id) {
    log.info("Hello2 {}", id);
    String[] field = {"a", "b", "c", "s", "e"};

    //concatenates strings using + in a loop
    String s = "";
    for (int i = 0; i < field.length; ++i) {
      s = s + field[i];
    }

    int a;

    System.out.println("a");
    if (id.endsWith("a")) {
      throw new AbcApiException(PRODUCT_NOT_FOUND, id);
    }
    return ResponseEntity.ok(Product.builder().id(ProductUtils.striangify(id)).build());

  }

}

