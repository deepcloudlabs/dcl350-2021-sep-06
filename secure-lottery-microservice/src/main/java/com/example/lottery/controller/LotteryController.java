package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.LotteryService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@RestController
@RequestScope
@RequestMapping("/numbers")
@CrossOrigin
@Validated
// Alt + Shift + S ==> Source Code Generation
public class LotteryController {
	@Value("${server.port}")
	private String serverPort;

	private LotteryService lotteryService;

	public LotteryController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@GetMapping(params = { "column" })
	public List<List<Integer>> getLotteryNumbers(@RequestParam @Validated int column) {
		System.err.println("New request has arrived for service running at port " + serverPort);
		return lotteryService.draw(column);
	}
}
