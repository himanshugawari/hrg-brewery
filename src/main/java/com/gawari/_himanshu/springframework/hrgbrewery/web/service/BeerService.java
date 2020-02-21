package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.List;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(Long beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(Long beerId, BeerDto beerDto);

	void deleteById(Long beerId);
	
	List<BeerDto> findAll(); 
}
