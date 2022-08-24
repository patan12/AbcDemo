/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

  @Bean
  OpenAPI apiInfo() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Swagger Catalog - OpenAPI 3.0")
                .description(
                    "This is a sample Catalog Server based on the OpenAPI 3.0 specification.")
                .termsOfService("http://swagger.io/terms/")
                .contact(
                    new Contact()
                        .email("apiteam@swagger.io")
                )
                .license(
                    new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                )
                .version("1.0.11")
        )
        .components(
            new Components()
                .addSecuritySchemes("api_key", new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)
                    .name("api_key")
                )
                .addSecuritySchemes("petstore_auth", new SecurityScheme()
                    .type(SecurityScheme.Type.OAUTH2)
                )
        )
        ;
  }
}