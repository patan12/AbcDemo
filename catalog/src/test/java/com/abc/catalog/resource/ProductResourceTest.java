/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.abc.catalog.model.Product;
import com.abc.catalog.resource.ProductResource;
import com.abc.catalog.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ProductResourceTest {

  @Mock
  ProductService productService;

  @InjectMocks
  ProductResource productResource;

  @Test
  public void shall_get_product_by_id() {
    //given
    String id = "aa";
    Product product = Product.builder().id("id").name("name").barcode("barcode").build();
    when(productService.getProduct(eq(id))).thenReturn(product);

    //when
    ResponseEntity<Product> result = productResource.getProduct(id);

    //then
    assertThat(result.getBody()).isEqualTo(product);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
