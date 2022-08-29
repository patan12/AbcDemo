Feature: Products API Test

  As a user
  I want an get Product Details

  Scenario: Send a Request for Product Details
    Given application is up
    When I send a request to get product details of "<productId>"
    Then the response will return status 200 and id "<productId>" and barcode "<barcode>" and name "<name>"

    Examples:
    |productId    |barcode       |name             |
    |10001        |12345         |Product          |
    |10002        |12345         |Product          |
    |10003        |12345         |Product          |