package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */

/*
cd c:\DEVEL\stage\tmp\
mkdir softtech-2021-sep-09
cd softtech-2021-sep-09
git init
notepad lottery.properties
git add lottery.properties
git commit -m "initial commit"
*/

// curl localhost:2023/lottery/api/v1/actuator/refresh -X POST -d {} -H "Content-Type: application/json"
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class LotteryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryMicroserviceApplication.class, args);
	}

}
