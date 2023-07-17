package com.benaya.assignments.clientapi.service;

import com.benaya.assignments.clientapi.exception.IpGeoLocationNotFoundException;
import com.benaya.assignments.clientapi.model.IpGeoLocation;
import com.benaya.assignments.clientapi.repository.IpGeoLocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class IpGeoLocationService {

    private final IpGeoLocationRepository ipGeoLocationRepository;
    private final RestTemplate restTemplate;

    public void addIpGeoLocation(String ip) {
        IpGeoLocation ipGeoLocation = restTemplate
                .getForObject(ip, IpGeoLocation.class);
        ipGeoLocationRepository.save(Objects.requireNonNull(ipGeoLocation));
    }
    public IpGeoLocation getIpGeoLocation(String ip) {
        return ipGeoLocationRepository.findById(ip).orElseThrow(IpGeoLocationNotFoundException::new);
    }
}
