package com.david.userservice.config;

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
              .info(new Info().title("User-Service").description(
                       "User-Service Api Documentation with springdoc-openapi and OpenAPI 3."));

   }

}