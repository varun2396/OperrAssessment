package com.example.myapp.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.Model.Location;
import com.example.myapp.Repository.LocationRepository;

@RestController
public class LocationController {
	
	@Autowired
	private LocationRepository locationrepository;
	
	
	/**
	* addLocation is a CreateAPI that will help us create new instances in the Database
	* 
	* Input:
	* @RequestBody will take in values such as name, latitude and longitude
	* 
	* Output:
	* Will show us the value that has been entered in the Database
	* 
	* @author Varun Mishra
	* 
	*/
	
	
	
	@PostMapping("/operr/addLocation")
	public Location addLocation(@RequestBody Location l) {
		l.set_id(ObjectId.get());
		locationrepository.save(l);
		return l;
	}
	
	
	
	/**
	* getSpecificLocation is a GetAPI that will help us get a specific location by ID in Database
	* 
	* Input:
	* @PathVariable will take in ID to get a Specific Location
	* 
	* Output: 
	* Will return the Location object of the specified ID
	* 
	* @author Varun Mishra
	* 
	*/
	
	@GetMapping("/operr/getSpecificLocation/{id}")
	public Location getSpecificLocation(@PathVariable("id") ObjectId id) {
		return locationrepository.findBy_id(id); 
	}
	

	/**
	* getAllLocations is a GetAPI that will help us get al values in Database
	* 
	* Input:
	* Since it requires all position we would just hit the API
	* 
	* Output: 
	* Will return the list of Location objects of all locations
	* 
	* @author Varun Mishra
	* 
	*/
	
	@GetMapping("/operr/getAllLocations")
	public List<Location> getAllLocations(){
		return locationrepository.findAll();
	}
	

	/**
	* updateLocation is a PutAPI that will help us update a specific location by ID in Database
	* 
	* Input:
	* @PathVariable will take in ID to get a Specific Location
	* @RequestBody will take the update values 
	* 
	* Output: 
	* Will return the Location object of the specified ID that has been updated
	* 
	* @author Varun Mishra
	* 
	*/
	
	@PutMapping("/operr/updateLocation/{id}")
	public Location updateLocation(@PathVariable("id") ObjectId id, @RequestBody Location l) {
		l.set_id(id);
		locationrepository.save(l);
		return l;
	}
	
	/**
	* updateLocation is a Delete API that will help us delete a specific location by ID in Database
	* 
	* Input:
	* @PathVariable will take in ID to get a Specific Location
	* 
	* Output: 
	* Will delete the entry and notify the id that has been deleted
	* 
	* @author Varun Mishra
	* 
	*/
	
	@DeleteMapping("/operr/deleteLocation/{id}")
	public String deleteLocation(@PathVariable("id") ObjectId id) {
		locationrepository.delete(locationrepository.findBy_id(id));
		return "id " + id + "has been deleted";
	}
	
	/**
	* updateLocation is a Get API that will help us find a specific location within a radius in Database
	* 
	* Input:
	* @PathVariable will take in radius within to get all Location within radius
	* @RequestBody will take the values of the latitude and longitude
	* 
	* Output: 
	* Will return the list of Location object that specify the parameter
	* 
	* @author Varun Mishra
	* 
	*/

	@GetMapping("/operr/getNearByLocations/{withinRadius}")
    public List<Location> getNearbyLocations(@RequestBody Location l, @PathVariable("withinRadius") double radius) {
		Circle c = new Circle(l.getLatitude(), l.getLongitude(), radius);
		System.out.println(c);
		List<Location> locations = locationrepository.findByPositionWithin(c);
		return locations;
    }
}
