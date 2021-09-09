package com.example.lottery.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.lottery.remote.LotteryService;

@Service
public class LotteryConsumerServiceWithFeignClient {

	private LotteryService lotteryService;
	
	public LotteryConsumerServiceWithFeignClient(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		System.err.println(lotteryService.getLotteryNumbers(3));
	}
}
