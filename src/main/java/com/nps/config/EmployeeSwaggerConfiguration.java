package com.nps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class EmployeeSwaggerConfiguration {
	@Bean
	public Docket apiDocs() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nps.rest")) // .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	/*
	 * @Bean public Docket apiDoc() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.nps.rest")).paths(
	 * PathSelectors.any()) .build(); }
	 */
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee API")
				.description("Employee Service API reference for developer")
				.termsOfServiceUrl("https://nps.com")
				.contact(new Contact("Mukesh", "https://github.com/jcalaz", "nps@gmail.com"))
				.license("NPS")
				.version("1.0")
				.licenseUrl("nps@gmail.com")
				.build();
	}
}
