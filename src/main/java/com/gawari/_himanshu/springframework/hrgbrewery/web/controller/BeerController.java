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

	@GetMapping(value = "/all")
	public List<BeerDto> getAllBeer() {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return beerService.findAll();
	}

	@GetMapping(value = "/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") Long beerId) {
		// return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {
		BeerDto saveBeerDto = beerService.saveNewBeer(beerDto);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "/api/v1/beer/" + saveBeerDto.getId().toString());
		return new ResponseEntity<BeerDto>(header, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") Long beerId, @RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId, beerDto);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "/api/v1/beer/" + beerId.toString());
		return new ResponseEntity<BeerDto>(header, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{beerId}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<BeerDto> deleteBeer(@PathVariable("beerId") Long beerId) {
		beerService.deleteById(beerId);
		return new ResponseEntity<BeerDto>(HttpStatus.ACCEPTED);
	}
}
