/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.resource;

import static com.abc.catalog.model.ErrorCode.PRODUCT_NOT_FOUND;

import com.abc.catalog.exception.AbcApiException;
import com.abc.catalog.model.Product;
import com.abc.catalog.service.ProductService;
import com.abc.catalog.utils.ProductUtils;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductResource {

  private ProductService productService;

  @Autowired
  public ProductResource(ProductService productService) {
    this.productService = productService;
  }


  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable final String id) {
    log.info("Hello2 {}", id);
    return ResponseEntity.ok(productService.getProduct(id));

  }

  @PostMapping
  public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
    productService.createProduct(product);
    return ResponseEntity.ok(product);
  }
}

