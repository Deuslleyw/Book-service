package com.Deusley.bookservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(info =
@Info(title = "Api Book Service",
version = "1.0",
description = "Documentation of Api Book Service"))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Api Book Service")
                        .version("1.0")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")));

    }
}
