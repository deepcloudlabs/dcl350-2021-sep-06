package com.example.crm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.entity.Customer;
import com.example.crm.service.CrmReadService;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CrmReadRestController {
	private CrmReadService crmSrv;

	public CrmReadRestController(CrmReadService crmSrv) {
		this.crmSrv = crmSrv;
	}

	@GetMapping("{identity}")
	public Customer findByIdentity(@PathVariable String identity) {
		return crmSrv.findCustomerById(identity).orElseThrow(() -> new IllegalArgumentException("Cannot find the customer"));
	}

	@GetMapping(params = { "no", "size" })
	public List<Customer> findAllByPage(@RequestParam int no, @RequestParam int size) {
		return crmSrv.findAllCustomersByPage(no, size);
	}

}
