/*
 * Copyright (c) 2022 Abc Co. All rights reserved.
 */

package com.abc.catalog;

import static java.time.format.DateTimeFormatter.ofPattern;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Slf4j
public class CatalogApplication {

  public static void main(String[] args) {
    SpringApplication.run(CatalogApplication.class, args);
  }

  @Bean
  @Primary
  public ObjectMapper serializingObjectMapper() {
    return getObjectMapper();
  }

  /**
   * ObjectMapper object mapper.
   * @return
   */
  public static ObjectMapper getObjectMapper() {
    JavaTimeModule javaTimeModule = new JavaTimeModule();
    DateTimeFormatter dateTimeFormatter = ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    DateTimeFormatter dateFormatter = ofPattern("yyyy-MM-dd");

    javaTimeModule.addSerializer(LocalDateTime.class,
        new LocalDateTimeSerializer(dateTimeFormatter));
    javaTimeModule.addDeserializer(LocalDateTime.class,
        new LocalDateTimeDeserializer(dateTimeFormatter));

    javaTimeModule.addSerializer(LocalDate.class,
        new LocalDateSerializer(dateFormatter));
    javaTimeModule.addDeserializer(LocalDate.class,
        new LocalDateDeserializer(dateFormatter));

    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.registerModule(javaTimeModule);
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    return objectMapper;
  }

}
