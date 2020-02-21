package com.gawari._himanshu.springframework.hrgbrewery.web.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	private static List<BeerDto> beers = new ArrayList<>();
	private static Long beerCount = 3L;

	static {
		beers.add(new BeerDto(1L, "Brooklyn Brown Ale", "Brown Ales"));
		beers.add(new BeerDto(2L, "Black Sheep Ale", "Pale Ales"));
		beers.add(new BeerDto(3L, "Lagunitas Maximus", "India Pale Ales"));
	}

	@Override
	public List<BeerDto> findAll() {
		return beers;
	}

	@Override
	public BeerDto getBeerById(Long beerId) {
		for (BeerDto beer : beers) {
			if (beer.getId()==beerId)
				return beer;
		}
		return null;
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		if (beerDto.getId()==null) {
			beerDto.setId(++beerCount);
		}
		beers.add(beerDto);
		return beerDto;
	}

	@Override
	public void updateBeer(Long beerId, BeerDto beerDto) {
		BeerDto beer = getBeerById(beerId);
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle());
		//deleteById(beer.getId());
		//saveNewBeer(beerDto);
	}

	@Override
	public void deleteById(Long beerId) {
		Iterator<BeerDto> iterator = beers.iterator();
		while (iterator.hasNext()) {
			BeerDto beer = iterator.next();
			if (beer.getId() == beerId)
				iterator.remove();
		}
	}

	/*
	 * @Override public BeerDto getBeerById(UUID beerId) { return
	 * BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").
	 * beerStyle("Pale Ale").build(); }
	 * 
	 * @Override public BeerDto saveNewBeer(BeerDto beerDto) { return
	 * BeerDto.builder().id(UUID.randomUUID()).build(); }
	 * 
	 * @Override public void updateBeer(UUID beerId, BeerDto beerDto) {
	 * log.debug("Updating a Beer"); }
	 * 
	 * @Override public void deleteById(UUID beerId) { log.debug("Deleting a Beer");
	 * }
	 */
}
