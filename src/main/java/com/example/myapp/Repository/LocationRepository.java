package com.example.myapp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myapp.Model.Location;


public interface LocationRepository extends MongoRepository<Location, String>{
	
}
