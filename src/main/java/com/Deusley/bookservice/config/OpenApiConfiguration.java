package com.Deusley.bookservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Book service API",
        version = "V01",
        description ="Documentation of Book Service API" ))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info( new io.swagger.v3.oas.models.info.Info()
                        .title("Book Service API")
                        .version("V01")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
