package com.benaya.assignments.clientapi.repository;

import com.benaya.assignments.clientapi.model.IpGeoLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IpGeoLocationRepository extends MongoRepository<IpGeoLocation, String>{


}
