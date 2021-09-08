package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGenerator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
public class StandardLotteryService implements LotteryService {
	@Value("${lotteryMax}")
	private int lotteryMax;
	@Value("${lotterySize}")
	private int lotterySize;
	
	private RandomNumberGenerator randomNumberGenerator;
	
	public StandardLotteryService(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public List<Integer> draw() {
		return IntStream.generate(() -> randomNumberGenerator.generate(1, lotteryMax)).distinct().limit(lotterySize).sorted().boxed()
				.collect(Collectors.toList());
	}

}