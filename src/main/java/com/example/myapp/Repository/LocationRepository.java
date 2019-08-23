package com.example.myapp.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myapp.Model.Location;


public interface LocationRepository extends MongoRepository<Location, String>{

	Location findBy_id(ObjectId _id);
	
    List<Location> findByPositionWithin(Circle c);	
    
}
