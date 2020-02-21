package com.gawari._himanshu.springframework.hrgbrewery.web.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") Long customerId) {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public List<CustomerDto> getAllCustomer() {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return customerService.findAllCustomer();
	}

	@PostMapping
	public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto saveCustomerDto = customerService.saveNewCustomer(customerDto);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "/api/v1/customer/" + saveCustomerDto.getId().toString());
		return new ResponseEntity<CustomerDto>(header, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{customerId}")
	public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("customerId") Long customerId,
			@RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerId, customerDto);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "/api/v1/customer/" + customerId.toString());
		return new ResponseEntity<CustomerDto>(header, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{customerId}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<CustomerDto> deleteBeer(@PathVariable("customerId") Long customerId) {
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<CustomerDto>(HttpStatus.ACCEPTED);
	}
}
