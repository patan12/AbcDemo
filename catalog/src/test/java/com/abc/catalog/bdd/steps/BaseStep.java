/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.web.server.LocalServerPort;
/*
    RestSteps.
 */

public abstract class BaseStep {

  private final static String WEB_BASE_PATH = "/api/catalog/";
  private final static String ACTUATOR_BASE_PATH = "/api/catalog/monitor";
  private final static String BASE_URI = "http://localhost";

  @LocalServerPort
  private int port;

  private void configureRestAssured() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.port = port;
    RestAssured.basePath = WEB_BASE_PATH;
  }

  private void configureRestAssuredActuator() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.port = port;
    RestAssured.basePath = ACTUATOR_BASE_PATH;
  }

  protected RequestSpecification requestSpecification() {
    configureRestAssured();
    return given();
  }

  protected RequestSpecification requestSpecificationActuator() {
    configureRestAssuredActuator();
    return given();
  }
}
