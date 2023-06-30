package com.getordeusuarios.getorusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.getordeusuarios.getorusuarios.controllers"})
public class GetorusuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetorusuariosApplication.class, args);
	}

}
