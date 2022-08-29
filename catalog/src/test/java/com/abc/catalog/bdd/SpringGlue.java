/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.abc.catalog.CatalogApplication;
import com.abc.catalog.model.Product;
import com.abc.catalog.service.ProductService;
import io.cucumber.spring.CucumberContextConfiguration;
import java.util.regex.Matcher;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.TestPropertySource;
/*
 Spring Glue.
 */

@CucumberContextConfiguration
@SpringBootTest(classes = {CatalogApplication.class, SpringGlue.TestConfig.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestPropertySource("classpath:test-application.properties")
public class SpringGlue {

  @TestConfiguration
  public static class TestConfig {
    @Bean
    @Primary
    public ProductService productService(){
      ProductService productService = Mockito.mock(ProductService.class);
      when(productService.getProduct(any())).thenReturn(Product.builder().id("aa").barcode("aa").name("he").build());
      return productService;
    }

  }

}
