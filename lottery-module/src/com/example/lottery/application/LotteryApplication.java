package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberGenerator;
import com.example.random.service.ServiceQuality;

public class LotteryApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ServiceLoader<RandomNumberGenerator> generators = ServiceLoader.load(RandomNumberGenerator.class);
		var sls = new StandardLotteryService();
		// setter injection
		sls.setRandomNumberGenerator(selectImplementation(generators, readProperty("service.quality")).get());
		for (var i = 0; i < 10; ++i)
			System.err.println(sls.draw());
	}

	private static String readProperty(String key) throws FileNotFoundException, IOException {
		var properties = new Properties();
		properties.load(new FileInputStream(new File("src","application.properties")));
		return properties.get(key).toString();
	}

	private static Optional<RandomNumberGenerator> selectImplementation(ServiceLoader<RandomNumberGenerator> generators,
			String serviceQuality) {
		for (var rng : generators) {
			Class<?> clazz = rng.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQualityLevel = clazz.getAnnotation(ServiceQuality.class).value().name();
				if (serviceQualityLevel.equals(serviceQuality)) {
					return Optional.of(rng);
				}
			}
		}
		return Optional.empty();
	}
}
