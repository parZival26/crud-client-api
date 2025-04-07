package com.parZival26.crud_client_api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Clientes")
                        .version("1.0")
                        .description("API REST para la gestión de clientes")
                        .contact(new Contact()
                                .name("parZival26")
                                ));
    }
}
