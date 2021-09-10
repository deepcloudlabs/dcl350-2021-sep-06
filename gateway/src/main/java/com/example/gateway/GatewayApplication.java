package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:6100          /gateway    /lottery   /api/v1  /numbers?column=3
//    server.servlet.context-path=/gateway       /\       /\      /\ 
//    spring.application.name=lottery ------------|        |       |
//    spring.mvc.servlet.path=/api/v1 ---------------------|       |
//    @RestController @RequestMapping("/numbers") -----------------|
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
