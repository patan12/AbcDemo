/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.api;

import com.abc.catalog.exception.ErrorDetail;
import com.abc.catalog.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/*
 Product Interface.
 */
@Tag(name = "product", description = "Everything about products")
public interface ProductApi {

  /**
   * GET /products/{id} : Find Product by ID Returns a single Product.
   *
   * @param id ID of product to return (required)
   * @return successful operation (status code 200)
   * <p>
   * or HTTP 400. The request cannot be fulfilled because of incorrect syntax or input (status code
   * 400) or HTTP 401. server is yet to receive an authentication or received incorrect
   * authentication as in the case of Bad credentials, Authentication server issues (status code
   * 401) or HTTP 403. The request has valid credentials but may not have enough privileges to
   * perform an action on a resource (status code 403) or HTTP 404. The specified resource was not
   * found and may or may not be available in future (status code 404) or HTTP 406. The specified
   * resource exists but in a different format. The server cannot produce a response matching the
   * list of acceptable values defined in the request&#39;s proactive content negotiation headers
   * (such as Accept Language, Accept Encoding), and that the server is unwilling to supply a
   * default representation. (status code 406) or HTTP 415.  The request body contains a media type
   * which is not supported by the server, hence it is rejected. (status code 415) or HTTP 429. The
   * user has sent too many requests in a given amount of time (\&quot;rate limiting\&quot;). A
   * Retry-After header might be included to this response indicating how long to wait before making
   * a new request. (status code 429) or Default unsuccessful response model (status code 200)
   */
  @Operation(
      operationId = "getProductById",
      summary = "Find product by ID",
      tags = {"product"},
      responses = {
          @ApiResponse(responseCode = "200", description = "successful operation", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = Product.class))
          }),
          @ApiResponse(responseCode = "400", description = "HTTP 400. The request cannot be fulfilled because of incorrect syntax or input", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "401", description = "HTTP 401. server is yet to receive an authentication or received incorrect authentication as in the case of Bad credentials, Authentication server issues", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "403", description = "HTTP 403. The request has valid credentials but may not have enough privileges to perform an action on a resource", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "404", description = "HTTP 404. The specified resource was not found and may or may not be available in future", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "406", description = "HTTP 406. The specified resource exists but in a different format. The server cannot produce a response matching the list of acceptable values defined in the request's proactive content negotiation headers (such as Accept Language, Accept Encoding), and that the server is unwilling to supply a default representation.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "415", description = "HTTP 415.  The request body contains a media type which is not supported by the server, hence it is rejected.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "429", description = "HTTP 429. The user has sent too many requests in a given amount of time (\"rate limiting\"). A Retry-After header might be included to this response indicating how long to wait before making a new request.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class)),
              @Content(mediaType = "application/xml", schema = @Schema(implementation = ErrorDetail.class))
          })
      },
      security = {
          @SecurityRequirement(name = "api_key"),
          @SecurityRequirement(name = "productstore_auth", scopes = {"write:products",
              "read:products"})
      }
  )
  ResponseEntity<Product> getProduct(final String id);

  /**
   * POST /products : create a product
   *
   * @param product product data (required)
   * @return successful operation (status code 200) or HTTP 400. The request cannot be fulfilled
   * because of incorrect syntax or input (status code 400) or HTTP 401. server is yet to receive an
   * authentication or received incorrect authentication as in the case of Bad credentials,
   * Authentication server issues (status code 401) or HTTP 403. The request has valid credentials
   * but may not have enough privileges to perform an action on a resource (status code 403) or HTTP
   * 404. The specified resource was not found and may or may not be available in future (status
   * code 404) or HTTP 406. The specified resource exists but in a different format. The server
   * cannot produce a response matching the list of acceptable values defined in the request&#39;s
   * proactive content negotiation headers (such as Accept Language, Accept Encoding), and that the
   * server is unwilling to supply a default representation. (status code 406) or HTTP 415.  The
   * request body contains a media type which is not supported by the server, hence it is rejected.
   * (status code 415) or HTTP 429. The user has sent too many requests in a given amount of time
   * (\&quot;rate limiting\&quot;). A Retry-After header might be included to this response
   * indicating how long to wait before making a new request. (status code 429) or Default
   * unsuccessful response model (status code 200)
   */
  @Operation(
      operationId = "create a new Product",
      summary = "create a new product with data",
      tags = {"product"},
      responses = {
          @ApiResponse(responseCode = "200", description = "successful operation", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
          }),
          @ApiResponse(responseCode = "400", description = "HTTP 400. The request cannot be fulfilled because of incorrect syntax or input", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "401", description = "HTTP 401. server is yet to receive an authentication or received incorrect authentication as in the case of Bad credentials, Authentication server issues", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "403", description = "HTTP 403. The request has valid credentials but may not have enough privileges to perform an action on a resource", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "404", description = "HTTP 404. The specified resource was not found and may or may not be available in future", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "406", description = "HTTP 406. The specified resource exists but in a different format. The server cannot produce a response matching the list of acceptable values defined in the request's proactive content negotiation headers (such as Accept Language, Accept Encoding), and that the server is unwilling to supply a default representation.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "415", description = "HTTP 415.  The request body contains a media type which is not supported by the server, hence it is rejected.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "429", description = "HTTP 429. The user has sent too many requests in a given amount of time (\"rate limiting\"). A Retry-After header might be included to this response indicating how long to wait before making a new request.", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          }),
          @ApiResponse(responseCode = "200", description = "Default unsuccessful response model", content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetail.class))
          })
      },
      security = {
          @SecurityRequirement(name = "api_key"),
          @SecurityRequirement(name = "productstore_auth", scopes = {"write:products",
              "read:products"})
      }
  )
  ResponseEntity<Product> createProduct(@Valid @RequestBody Product product);
}

