package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.List;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.CustomerDto;

public interface CustomerService {
	// CustomerDto getCustomerById(Integer customerId);
	// CustomerDto getCustomerById(UUID customerId);

	CustomerDto getCustomerById(Long customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomer(Long customerId, CustomerDto customerDto);

	void deleteCustomerById(Long customerId);

	List<CustomerDto> findAllCustomer();
}
