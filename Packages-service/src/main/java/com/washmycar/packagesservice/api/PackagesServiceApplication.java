package com.washmycar.packagesservice.api;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@OpenAPIDefinition(info=@Info(title="Wash My Car Application", version="1.0",description="Service-Packages microservice"))
@EnableSwagger2
@SpringBootApplication
public class PackagesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagesServiceApplication.class, args);
	}

}
