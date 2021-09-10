package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;


public class StandardLotteryService implements LotteryService {	
	private RandomNumberGenerator randomNumberGenerator;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public List<Integer> draw() {
		return IntStream.generate(() -> randomNumberGenerator.generate(1, 60)).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

}