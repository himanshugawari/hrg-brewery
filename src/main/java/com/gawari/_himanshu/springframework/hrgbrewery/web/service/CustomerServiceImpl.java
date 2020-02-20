package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Code for Integer ID
	/*
	 * private static List<CustomerDto> customers = new ArrayList<>(); static {
	 * customers.add(new CustomerDto(1, "Adam")); customers.add(new CustomerDto(2,
	 * "Eve")); customers.add(new CustomerDto(3, "Jack")); }
	 * 
	 * @Override public CustomerDto getCustomerById(Integer customerId) { for
	 * (CustomerDto customer : customers) { if (customer.getId() == customerId)
	 * return customer; } return null; }
	 */

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID()).customerName("Himanshu").build();
	}
}

