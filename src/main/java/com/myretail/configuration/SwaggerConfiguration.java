package com.myretail.configuration;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfiguration {
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("product")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/product.*"))
                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("myRetail Services Documentation")
                .description("Documentation of myRetail product services")
                .contact("Kartheek Maremalla")
                .license("Apache License Version 2.0")
                .version("2.0")
                .build();
    }

}
