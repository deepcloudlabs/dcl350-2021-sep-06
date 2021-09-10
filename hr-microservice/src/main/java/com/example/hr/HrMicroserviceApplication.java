package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// 1.) Cloud Foundry: https://cloud.spring.io/spring-cloud-cloudfoundry
// 2.) Docker+k8s: mvn clean install spring-boot:repackage -> jar -> Dockerfile -> Image -> jdk 11+
//                                                   k8s + docker -> Azure/GCP/AWS/...
// 3.) Registry+Load Balancer+API Gateway+Distributed Logging+Monitoring+...
//     CI/CD Pipeline
//     Azure, GCP, AWS
// 4.) 2) -> On-premise/Private (OpenStack, OpenShift, ...)
@SpringBootApplication
public class HrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrMicroserviceApplication.class, args);
	}

}
