package com.example.crm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.boundary.response.AcquireCustomerReponse;
import com.example.crm.entity.Customer;
import com.example.crm.service.CrmWriteService;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CrmWriteRestController {
	private CrmWriteService crmSrv;

	public CrmWriteRestController(CrmWriteService crmSrv) {
		this.crmSrv = crmSrv;
	}

	@PostMapping
	public AcquireCustomerReponse acquireCustomer(@RequestBody Customer customer) {
		crmSrv.acquireCustomer(customer);
		return new AcquireCustomerReponse("success");
	}
}
