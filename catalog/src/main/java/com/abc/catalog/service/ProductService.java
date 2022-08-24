/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.service;

import static com.abc.catalog.model.ErrorCode.PRODUCT_ALREADY_EXIST;
import static com.abc.catalog.model.ErrorCode.PRODUCT_NOT_FOUND;

import com.abc.catalog.exception.AbcApiException;
import com.abc.catalog.model.Product;
import org.springframework.stereotype.Component;

/**
 * ProductService class.
 */
@Component
public class ProductService {

  /**
   * Get the product by id.
   * @param id product id
   * @return product with id
   */
  public Product getProduct(String id) {
    if (id.endsWith("a")) {
      throw new AbcApiException(PRODUCT_NOT_FOUND, id);
    }
    return Product.builder().id("pid").barcode("12345").name("Product").build();
  }

  /**
   * Create a product.
   *
   * @param product Product
   */
  public void createProduct(Product product) {
    // intentionally empty
    if (product.getId().endsWith("a")) {
      throw AbcApiException.ofMessage(PRODUCT_ALREADY_EXIST,
          "Product Already Exist with id " + product.getId());
    }
  }

}

