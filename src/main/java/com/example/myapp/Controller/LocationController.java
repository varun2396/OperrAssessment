package com.example.myapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.Model.Location;
import com.example.myapp.Repository.LocationRepository;

@RestController
public class LocationController {
	
	@Autowired
	private LocationRepository locationrepository;
	
	@GetMapping("/operr/getAllLocations")
	public List<Location> getAllLocations(){
		return locationrepository.findAll();
	}
}
