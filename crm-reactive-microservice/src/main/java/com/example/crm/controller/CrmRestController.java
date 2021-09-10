package com.example.crm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.entity.Customer;
import com.example.crm.service.CrmReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CrmRestController {
	private CrmReactiveService crmSrv;

	public CrmRestController(CrmReactiveService crmSrv) {
		this.crmSrv = crmSrv;
	}

	@GetMapping("{identity}")
	public Mono<Customer> findByIdentity(@PathVariable String identity) {
		return crmSrv.findCustomerById(identity);
	}

	@GetMapping(params = { "no", "size" })
	public Flux<Customer> findAllByPage(@RequestParam int no, @RequestParam int size) {
		return crmSrv.findAllCustomersByPage(no, size);
	}

	@PostMapping
	public Mono<Customer> acquireCustomer(@RequestBody Customer customer) {
		return crmSrv.addCustomer(customer);
	}

	@PutMapping("{identity}")
	public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable String identity) {
		return crmSrv.updateCustomer(identity, customer);
	}
	
	@DeleteMapping("{identity}")
	public Mono<Customer> releaseCustomer(@PathVariable String identity) {
		return crmSrv.removeCustomerById(identity);
	}
}
