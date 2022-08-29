/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
/*
  DocumentationSteps.
 */

public class DocumentationSteps {

  private final static String BASE_URI = "http://localhost";
  private final static String WEB_BASE_PATH = "/api/catalog/";

  @LocalServerPort
  private int port;

  private ValidatableResponse validatableResponse;


  private void configureRestAssured() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.port = port;
    RestAssured.basePath = WEB_BASE_PATH;
  }

  protected RequestSpecification requestSpecification() {
    configureRestAssured();
    return given();
  }

  @Autowired
  protected MockMvc mvc;

  private ResultActions performedActions;

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
