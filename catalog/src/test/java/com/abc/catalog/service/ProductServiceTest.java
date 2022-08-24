/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.abc.catalog.exception.AbcApiException;
import com.abc.catalog.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @InjectMocks
  ProductService productService;

  @Test
  public void shall_get_product_by_id() {
    //given
    String id = "ab";

    //when
    Product result = productService.getProduct(id);

    //then
    assertThat(result).isEqualTo(
        Product.builder().id("pid").barcode("12345").name("Product").build());
  }

  @Test
  public void shall_create_product() {
    //given
    String id = "ab";
    Product product = Product.builder().id("pid").barcode("12345").name("Product ").build();

    //when
    productService.createProduct(product);

    //then
    //intentional
  }

  @Test
  public void shall_create_product_exception() {
    //given
    String id = "ab";
    Product product = Product.builder().id("pia").barcode("12345").name("Product ").build();


    //when
    Throwable exception = assertThrows(AbcApiException.class,
        () -> productService.createProduct(product)
    );
    //then
    assertThat(exception.getMessage()).contains("Product Already Exist with id pia");
  }

}
