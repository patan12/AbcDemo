/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
/*
  DocumentationSteps.
 */

public class DocumentationSteps extends BaseStep{

  private ValidatableResponse validatableResponse;

  @When("I request the Open API specifications")
  public void iRequestTheOpenAPISpecifications() throws Exception {

    validatableResponse = requestSpecification()
        .log().all()
        .contentType(ContentType.JSON)
        .when().get("/v3/api-docs")
        .then()
        .log().all();

  }

  @Then("I receive the specs for the application")
  public void iReceiveTheSpecsForTheApplication() throws Exception {
    validatableResponse.assertThat().statusCode(equalTo(200));

    String openAPiVersion = validatableResponse.extract()
        .body()
        .jsonPath()
        .getString("openapi");

    assertThat(openAPiVersion).isEqualTo("3.0.1");
  }
}
