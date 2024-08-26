package com.pascal.api.blogger.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Blog Posts API",
                description = "API para administrar publicaciones de blogs",
                version = "1.0.0",
                contact = @Contact(
                        name = "Pascal",
                        email = "pascalthedog542@gmail.com"
                )
        )
)
public class SwaggerConfig {}
