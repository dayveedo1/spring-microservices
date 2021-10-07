package com.david.departmentservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
   @Bean
   public OpenAPI customOpenAPI() {
       return new OpenAPI()
                .components(new Components())
              .info(new Info().title("Department-Service").description(
                       "Department-Service Api Documentation with springdoc-openapi and OpenAPI 3."));

   }

}