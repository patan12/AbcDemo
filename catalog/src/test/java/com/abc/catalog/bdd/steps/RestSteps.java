/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.abc.catalog.model.Product;
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
    RestSteps.
 */

public class RestSteps {

  private final static String ACTUATOR_BASE_PATH = "/api/catalog/";
  private final static String BASE_URI = "http://localhost";

  @Autowired
  protected MockMvc mvc;

  @LocalServerPort
  private int port;

  private ValidatableResponse validatableResponse;

  private ResultActions performedActions;

  private void configureRestAssured() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.port = port;
    RestAssured.basePath = ACTUATOR_BASE_PATH;
  }

  protected RequestSpecification requestSpecification() {
    configureRestAssured();
    return given();
  }

  @When("I send a message {string}")
  public void sendProductMessage(String message) throws Exception {

    validatableResponse = requestSpecification()
        .log().all()
        .contentType(ContentType.JSON)
        .when().get("/products/{id}", message)
        .then()
        .log().all();

  }

  @Then("API replies {string}")
  public void apiReplies(String expectedReply) throws Exception {
    validatableResponse.assertThat().statusCode(equalTo(200));
    Product result = validatableResponse.extract().body().as(Product.class);

    assertThat(result).isEqualTo(
        Product.builder().id(expectedReply).barcode("12345").name("Product").build());
  }
}
