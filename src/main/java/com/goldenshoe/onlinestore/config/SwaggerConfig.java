package com.goldenshoe.onlinestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by aliyussef on 28/04/2021
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Golden Shoe", "http://www.goldenshoe.com", "info@goldenshoe.com");

    private static final ApiInfo API_INFO = new ApiInfo(
            "Golden Shoe Online Store API", "Golden Shoe Online Store API", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(API_INFO)
                .consumes(new HashSet<>(Collections.singletonList("application/json")))
                .produces(new HashSet<>(Collections.singletonList("application/json")))
                .select()
                .apis(requestHandler -> requestHandler.groupName().contains("controller"))
                .build();
    }
}
