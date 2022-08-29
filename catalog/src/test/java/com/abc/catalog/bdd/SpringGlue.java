/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd;

import com.abc.catalog.CatalogApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
/*
 Spring Glue.
 */

@CucumberContextConfiguration
@SpringBootTest(classes = CatalogApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestPropertySource("classpath:test-application.properties")
public class SpringGlue {

}
