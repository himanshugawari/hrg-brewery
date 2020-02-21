package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static List<CustomerDto> customers = new ArrayList<>();
	private static Long customerCount = 3L;

	static {
		customers.add(new CustomerDto(1L, "Himanshu"));
		customers.add(new CustomerDto(2L, "Hardik"));
		customers.add(new CustomerDto(3L, "tim"));
	}

	@Override
	public CustomerDto getCustomerById(Long customerId) {
		for (CustomerDto customer : customers) {
			if (customer.getId() == customerId)
				return customer;
		}
		return null;
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		if (customerDto.getId() == null) {
			customerDto.setId(++customerCount);
		}
		customers.add(customerDto);
		return customerDto;
	}

	@Override
	public void updateCustomer(Long customerId, CustomerDto customerDto) {
		CustomerDto cutomer = getCustomerById(customerId);
		cutomer.setCustomerName(customerDto.getCustomerName());
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		Iterator<CustomerDto> iterator = customers.iterator();
		while (iterator.hasNext()) {
			CustomerDto customers = iterator.next();
			if (customers.getId() == customerId)
				iterator.remove();
		}
	}

	@Override
	public List<CustomerDto> findAllCustomer() {
		return customers;
	}

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

	/*
	 * @Override public CustomerDto getCustomerById(UUID customerId) { return
	 * null;//CustomerDto.builder().id(UUID.randomUUID()).customerName("Himanshu").
	 * build(); }
	 */

}
