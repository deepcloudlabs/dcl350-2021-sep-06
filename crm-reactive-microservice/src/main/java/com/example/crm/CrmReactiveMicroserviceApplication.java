package com.example.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// curl "http://localhost:3030/customers/1"
// curl "http://localhost:3030/customers?no=0&size=10"
// curl -X POST "http://localhost:3030/customers" -d "{\"identity\": \"1\", \"fullname\":\"jack bauer\", \"email\": \"jack@example.com\", \"phones\": [\"+902125555555\"],\"birthYear\": 1956}" -H "Content-Type: application/json" -H "Accept: application/json"
// curl -X PUT "http://localhost:3030/customers/1" -d "{\"identity\": \"1\", \"fullname\":\"jack bauer\", \"email\": \"jack@example.com.tr\", \"phones\": [\"+902125555555\",\"+902124444444\"],\"birthYear\": 1956}" -H "Content-Type: application/json" -H "Accept: application/json"
// curl -X DELETE "http://localhost:3030/customers/1"

@SpringBootApplication
public class CrmReactiveMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmReactiveMicroserviceApplication.class, args);
	}

}
