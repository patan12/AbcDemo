/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.web.server.LocalServerPort;

/*
 ActuatorSteps Test.
 */

public class ActuatorSteps {

  private final static String ACTUATOR_BASE_PATH = "/api/catalog/monitor/";
  private final static String BASE_URI = "http://localhost";

  @LocalServerPort
  private int port;

  private ValidatableResponse validatableResponse;


  private void configureRestAssured() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.port = port;
    RestAssured.basePath = ACTUATOR_BASE_PATH;
  }

  protected RequestSpecification requestSpecification() {
    configureRestAssured();
    return given();
  }

  @Given("application is up")
  public void applicationIsUp() throws Exception {
    validatableResponse = requestSpecification()
        .log().all()
        .contentType(ContentType.JSON)
        .when().get("/health").then();

    validatableResponse.assertThat().statusCode(equalTo(200));

    String status = validatableResponse.extract()
        .body()
        .jsonPath()
        .getString("status");

    assertThat(status).isEqualTo("UP");
  }
}
