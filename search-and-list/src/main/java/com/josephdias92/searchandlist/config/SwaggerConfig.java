package com.josephdias92.searchandlisting.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My REST API")
                        .description("API for managing products")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("John Doe")
                                .email("johndoe@example.com")
                                .url("https://johndoe.example.com"))
                );
    }
}
