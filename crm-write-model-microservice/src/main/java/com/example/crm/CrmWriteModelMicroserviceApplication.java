package com.example.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Rollback -> logical/physical delete events (transactionId)
@SpringBootApplication
public class CrmWriteModelMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmWriteModelMicroserviceApplication.class, args);
	}

}
