package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.UUID;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);
}
