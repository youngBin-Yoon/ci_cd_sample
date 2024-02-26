package com.example.demo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/emps/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Dj learing swagger", 
	      "DJ learing swagger from online", 
	      "dj_47", 
	      "Opern Source", 
	      new Contact("Dibyajyoti Behera", "www.example.com", "dibyajyoti.6025@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}
	
}
