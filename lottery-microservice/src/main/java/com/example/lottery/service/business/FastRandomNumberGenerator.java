package com.example.lottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberGenerator;
import com.example.lottery.service.ServiceQuality;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
@ServiceQuality(QualityLevel.FAST)
//@ConditionalOnProperty(name = "serviceQuality", havingValue = "FAST")
public class FastRandomNumberGenerator implements RandomNumberGenerator {

	@Override
	public int generate(int min, int max) {
		System.err.println("FastRandomNumberGenerator::generate");
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
