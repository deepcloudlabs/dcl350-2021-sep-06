package com.example.hr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.FireEmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;
import com.example.hr.service.HrService;


/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@RestController
@RequestScope
@RequestMapping("employees")
@CrossOrigin
// REST over HTTP
public class HrRestController { // [http] protocol adapter -> class method
	private HrService hrService;

	@PostMapping
	public HireEmployeeResponse hireEmployee(@RequestBody HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}

	@DeleteMapping("{identity}")
	public FireEmployeeResponse fireEmployee(@PathVariable String identity) {
		return hrService.fireEmployee(identity);
	}
}
