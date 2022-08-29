/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.abc.catalog.model.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
/*
    RestSteps.
 */

public class RestSteps extends BaseStep {

  private ValidatableResponse validatableResponse;

  @When("I send a request to get product details of {string}")
  public void iSendARequest(String productId ) {

    validatableResponse = requestSpecification()
        .log().all()
        .contentType(ContentType.JSON)
        .when().get("/products/{id}", productId)
        .then()
        .log().all();
  }

  @Then("the response will return status {int} and id {string} and barcode {string} and name {string}")
  public void extractResponse(int status, String id, String barcode,String name) {

    validatableResponse.assertThat().statusCode(equalTo(status));
    Product result = validatableResponse.extract().body().as(Product.class);

    assertThat(result).isEqualTo(
        Product.builder().id(id).barcode(barcode).name(name).build());

  }
}
