package com.benaya.assignments.clientapi.repository;

import com.benaya.assignments.clientapi.model.IpGeoLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IpGeoLocationRepository extends MongoRepository<IpGeoLocation, String>{

    Page<IpGeoLocation> findAllByIpStartingWith(Pageable pageable, String ip);
    Page<IpGeoLocation> findAllByCity(Pageable pageable, String city);
    Page<IpGeoLocation> findAllByCityStartingWith(Pageable pageable, String city);
    Page<IpGeoLocation> findAllByCountry(Pageable pageable, String country);
    Page<IpGeoLocation> findAllByCountryStartingWith(Pageable pageable, String country);


}
