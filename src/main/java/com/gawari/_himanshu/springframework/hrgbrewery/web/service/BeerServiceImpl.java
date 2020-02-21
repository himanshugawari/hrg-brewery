package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		log.debug("Updating a Beer");
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleting a Beer");
	}

}
