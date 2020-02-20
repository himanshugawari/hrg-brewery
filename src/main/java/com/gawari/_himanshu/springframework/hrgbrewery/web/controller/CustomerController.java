package com.gawari._himanshu.springframework.hrgbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.CustomerDto;
import com.gawari._himanshu.springframework.hrgbrewery.web.service.CustomerService;

@RestController
//@Controller
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// @ResponseBody
	@GetMapping(value = "/message")
	public String getHelloWorldMessage() {
		return "Hello World";
	}

	@GetMapping(value = "/message/{name}")
	public String getHelloWorldMessage(@PathVariable("name") String name) {
		return "Hello World, " + name;
	}

	// Code for Integer ID
	/*
	 * @GetMapping(value = "/{customerId}") public ResponseEntity<CustomerDto>
	 * getCustomerById(@PathVariable("customerId") Integer customerId) { // return
	 * new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK); return new
	 * ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId),
	 * HttpStatus.OK); }
	 */

	@GetMapping(value = "/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
}
