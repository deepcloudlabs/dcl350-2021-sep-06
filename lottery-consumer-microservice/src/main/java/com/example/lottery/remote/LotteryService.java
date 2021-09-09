package com.example.lottery.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("lottery") // spring.application.name=lottery
public interface LotteryService {

	@GetMapping("/api/v1/numbers")
	@Retry(name = "lottery", fallbackMethod = "callFallbackLottery")
	public List<List<Integer>> getLotteryNumbers(@RequestParam int column);

	public default List<List<Integer>> callFallbackLottery(int column,Throwable e) {
		System.err.println("Error type: "+e.getClass().getName());
		return List.of(List.of(1, 2, 3, 4, 5, 6), List.of(4, 8, 15, 16, 23, 42));
	}
}
