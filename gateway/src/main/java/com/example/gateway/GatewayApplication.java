package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://localhost:6100          /gateway    /lottery   /lottery/api/v1/numbers?column=3
//    server.servlet.context-path=/gateway       /\
//    spring.application.name=lottery ------------|                                         
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
