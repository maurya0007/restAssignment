package com.demo.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = { "com.demo.assignment" })
@EnableSwagger2
public class SampleAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAssignmentApplication.class, args);
	}

	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.assignment")).build();
	}

}
