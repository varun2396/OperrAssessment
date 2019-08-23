# OperrAssessment

# Create API for add/update/delete/getAll/getSpecific location from MongoDB

### Add Location: 
##### Url: /operr/addLocation
##### Input: Example: {    
    "name": "New jersey",
    "latitude": -100.0,
    "longitude": 100.0
}
##### Output: Value entered in Database



### Update Location By Id: 
##### Url: /operr/updateLocation/{id}
##### Input: Example: {    
    "name": "New York",
    "latitude": -100.0,
    "longitude": 100.0
}
##### URL : http://localhost:8080/operr/updateLocation/5d5f2af504300e33687803a9

##### Output: Value updated in Database


### Delete Location By ID:
##### URL:  /operr/deleteLocation/{id}
##### Example: URL : http://localhost:8080/operr/deleteLocation/5d5f2af504300e33687803a9


### Get All Location: 
##### URL: /operr/getAllLocations
##### Input:http://localhost:8080/operr/getAllLocations
##### Output: List of all Locations

### Get Specific Location By ID:
##### URL: /operr/getSpecificLocation/{id}
##### Input:http://localhost:8080/operr/getSpecificLocation/5d5f2af504300e33687803a9
##### Output: Location by Id


# Create API for getting all the locations within a certain radius(miles) based on the current location

### getting all the locations within a certain radius(miles): 
##### URL: /operr/getNearByLocations/{withinRadius}
##### Input: Example {    
    "latitude": -100.0,
    "longitude": 100.0
}
##### URL: /operr/getNearByLocations/2

##### Output: All locations within radius 2 and latitude and longitude as specified
