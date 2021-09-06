package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	private RandomNumberGenerator randomNumberGenerator;

	// public StandardLotteryService(RandomNumberGenerator randomNumberGenerator) {
	// 	this.randomNumberGenerator = randomNumberGenerator;
	// }

	// private List<RandomNumberGenerator> randomNumberGenerators;
	// private static final AtomicInteger counter = new AtomicInteger();

	// public StandardLotteryService(List<RandomNumberGenerator> randomNumberGenerators) {
	// 	this.randomNumberGenerators = randomNumberGenerators;
	// }

	
	//  public StandardLotteryService(@ServiceQuality(QualityLevel.SECURE) RandomNumberGenerator randomNumberGenerator) { 
	//	  this.randomNumberGenerator = randomNumberGenerator; 
	//  }
	 

	@Override
	public List<Integer> draw() {

		// var index = counter.getAndIncrement() % randomNumberGenerators.size();
		// var randomNumberGenerator = randomNumberGenerators.get(index);
		// List<Integer> list;
		// int x = 42;
		// 4-Byte Integer y = 42;
		// 12-Byte (Object Header) + 4-Byte = 16-Byte Integer i = 42;
		// Integer.valueOf(42); // Auto-Boxing: primitive -> wrapper

		return IntStream.generate(() -> randomNumberGenerator.generate(1, 60))
						.distinct()
						.limit(6)
						.sorted()
						.boxed()
						.collect(Collectors.toList());
	}

}