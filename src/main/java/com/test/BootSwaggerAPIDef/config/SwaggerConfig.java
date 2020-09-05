package com.test.BootSwaggerAPIDef.config;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/get.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Definition API")
				.description("Swagger Definition API reference for developers")
				.termsOfServiceUrl("https://github.com/SatishMHiremath")
				.contact(new Contact("xyz@gmail.com", "", "")).license("https://swagger.io/tools/swagger-ui/")
				.licenseUrl("https://swagger.io/license/").version("1.0").build();
	}

}