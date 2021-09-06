package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGenerator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
//@ServiceQuality(QualityLevel.SECURE)
@ConditionalOnProperty(name = "serviceQuality", havingValue = "SECURE")
public class SecureRandomNumberGenerator implements RandomNumberGenerator {
	private Random random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberGenerator::generate");
		return random.nextInt(max - min + 1) + min;
	}

}
