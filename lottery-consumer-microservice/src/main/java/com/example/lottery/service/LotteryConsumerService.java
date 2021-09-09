package com.example.lottery.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LotteryConsumerService {
	private DiscoveryClient discoveryClient;
	private List<ServiceInstance> instances;
	private static final AtomicInteger counter = new AtomicInteger();
	
	public LotteryConsumerService(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@PostConstruct
	public void loadServiceInstancesFromRegistryServer() {
		instances = discoveryClient.getInstances("lottery");
		instances.forEach( instance -> System.err.println(instance.getHost()+":"+instance.getPort()));
	}
	
	//@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		RestTemplate restTemplate = new RestTemplate();
		var instance = getNextServiceInstance();
		var url = String.format("http://%s:%d/lottery/api/v1/numbers?column=3",instance.getHost(),instance.getPort());
		var response = restTemplate.getForEntity(url, String.class).getBody();
		System.err.println(response);
	}

	private ServiceInstance getNextServiceInstance() {
		// Load balancing: Round-Robin
		return instances.get(counter.getAndIncrement() % instances.size());
	}
}
