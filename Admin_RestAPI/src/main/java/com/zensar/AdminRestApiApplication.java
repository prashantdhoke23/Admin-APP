package com.zensar;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AdminRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminRestApiApplication.class, args);
	}
	@Bean 
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket getCustomizedDocket() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.zensar"))
	.paths(PathSelectors.any())
	.build()
	.apiInfo(getApiInfo());

	}
	private ApiInfo getApiInfo() {
	ApiInfo apiInfo=new ApiInfo("Admin Rest Api Documentation",
	"This page gives Admin Rest API Doucmentation ", "2.5",
	"My Terms of services",
	new Contact("Admin Services System","http://localhot:7779","admin-team@zensar.com"),
	"GPL", "http://gpl.org",
	new ArrayList<VendorExtension>());
	return apiInfo;
	}
}
