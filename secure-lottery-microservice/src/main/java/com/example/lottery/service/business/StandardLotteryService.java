package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGenerator;
import com.example.lottery.service.ServiceQuality;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
public class StandardLotteryService implements LotteryService {
	@Value("${lotteryMax}") // SpEL
	private int lotteryMax;
	@Value("${lotterySize}")
	private int lotterySize;
	@Value("${serviceQuality}")
	private String serviceQuality;
	
	private RandomNumberGenerator randomNumberGenerator;
	private List<RandomNumberGenerator> randomNumberGenerators;
	
	public StandardLotteryService(List<RandomNumberGenerator> randomNumberGenerators) {
		this.randomNumberGenerators = randomNumberGenerators;
	}
	
	@PostConstruct
	public void selectImplementation() {
		for (var rng: randomNumberGenerators) {
			Class<?> clazz = rng.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQualityLevel = clazz.getAnnotation(ServiceQuality.class).value().name();
				if (serviceQualityLevel.equals(serviceQuality)) {
					this.randomNumberGenerator = rng;
					break;
				}
			}
		}
	}

	@Override
	public List<Integer> draw() {
		return IntStream.generate(() -> randomNumberGenerator.generate(1, lotteryMax)).distinct().limit(lotterySize).sorted().boxed()
				.collect(Collectors.toList());
	}

}