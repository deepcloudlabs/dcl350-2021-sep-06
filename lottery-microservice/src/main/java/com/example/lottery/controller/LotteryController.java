package com.example.lottery.controller;

import java.util.List;

import javax.validation.constraints.Min;

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

	private LotteryService lotteryService;

	public LotteryController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@GetMapping(params = { "column" })
	public List<List<Integer>> getLotteryNumbers(@RequestParam @Validated @Min(2) int column) {
		return lotteryService.draw(column);
	}
}
