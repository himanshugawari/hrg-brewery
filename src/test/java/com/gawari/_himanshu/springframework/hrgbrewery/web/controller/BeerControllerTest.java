package com.gawari._himanshu.springframework.hrgbrewery.web.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gawari._himanshu.springframework.hrgbrewery.web.model.BeerDto;
import com.gawari._himanshu.springframework.hrgbrewery.web.service.BeerService;

class BeerControllerTest {

	/*
	 * @MockBean BeerService beerService;
	 * 
	 * @Autowired MockMvc mockMvc;
	 * 
	 * @Autowired ObjectMapper objectMapper;
	 * 
	 * BeerDto validBeer;
	 * 
	 * @BeforeEach public void setUp() throws Exception { validBeer =
	 * BeerDto.builder().id(UUID.randomUUID()).beerName("Beer1").beerStyle(
	 * "PALE_ALE").upc(123456789012L) .build(); }
	 * 
	 * @Test public void getBeer() throws Exception {
	 * given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
	 * 
	 * mockMvc.perform(get("/api/v1/beer/" +
	 * validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isOk()).andExpect(content().contentType(MediaType.
	 * APPLICATION_JSON)) .andExpect(jsonPath("$.id",
	 * is(validBeer.getId().toString()))) .andExpect(jsonPath("$.beerName",
	 * is("Beer1"))); }
	 * 
	 * @Test public void handlePost() throws Exception { // given BeerDto beerDto =
	 * validBeer; beerDto.setId(null); BeerDto savedDto =
	 * BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build(); String
	 * beerDtoJson = objectMapper.writeValueAsString(beerDto);
	 * 
	 * given(beerService.saveNewBeer(any())).willReturn(savedDto);
	 * 
	 * mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON)
	 * .content(beerDtoJson)) .andExpect(status().isCreated());
	 * 
	 * }
	 * 
	 * @Test public void handleUpdate() throws Exception { // given BeerDto beerDto
	 * = validBeer; String beerDtoJson = objectMapper.writeValueAsString(beerDto);
	 * 
	 * // when mockMvc.perform( put("/api/v1/beer/" +
	 * validBeer.getId()).contentType(MediaType.APPLICATION_JSON).content(
	 * beerDtoJson)) .andExpect(status().isNoContent());
	 * 
	 * then(beerService).should().updateBeer(any(), any());
	 * 
	 * }
	 */

}
