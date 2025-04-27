package com.inditex.api.boot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration  {
    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.app.artifactId}")
    private String appArtifactId;
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info()
        .title(appName)
        .version(appVersion)
        .description(appDescription))
        .components(new Components()
        .addResponses("BadRequestResponse", createApiResponse("Bad Request", "400")));
    }

    private ApiResponse createApiResponse(String description, String statusCode) {
        return new ApiResponse()
        .description(description)
        .content(new Content().addMediaType("application/json",
        new MediaType().schema(new Schema<>().example("{\"status\": \"" + statusCode + "\", \"message\": \"" + description + "\"}"))));
    }
        
}
