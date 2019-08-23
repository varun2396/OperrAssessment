package com.example.myapp;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.myapp.Controller.LocationController;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(LocationController.class)
public class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;
	 
	@Test
	public void getAllLocations() throws Exception
	{
	  mvc.perform( (RequestBuilder) ((ResultActions) MockMvcRequestBuilders
	      .get("/operr/getAllLocations")))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());
	}
	
	@Test
	public void getLocationbyId() throws Exception
	{
	  mvc.perform( (RequestBuilder) ((ResultActions) MockMvcRequestBuilders
	      .get("/operr/getSpecificLocation/{id}", 1))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(1)));
	}
	
	@Test
	public void deleteLocation() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders.delete("/operr/deleteLocation/{id}", 1) )
	        .andExpect(status().isAccepted());
	}

}
