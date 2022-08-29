/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

/*
 ActuatorSteps Test.
 */

public class ActuatorSteps extends BaseStep{

  private ValidatableResponse validatableResponse;

  @Given("application is up")
  public void applicationIsUp() throws Exception {
    validatableResponse = requestSpecificationActuator()
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
