package com.gawari._himanshu.springframework.hrgbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;
import com.gawari._himanshu.springframework.hrgbrewery.web.service.BeerService;

@RestController
//@Controller
@RequestMapping(value = "/api/v1/beer")
public class BeerController {

	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
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

	@GetMapping(value = "/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
}
