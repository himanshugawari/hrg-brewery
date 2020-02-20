package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.UUID;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.CustomerDto;

public interface CustomerService {
	// CustomerDto getCustomerById(Integer customerId);
	CustomerDto getCustomerById(UUID customerId);
}
