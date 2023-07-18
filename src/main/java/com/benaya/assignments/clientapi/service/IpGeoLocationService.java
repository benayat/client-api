package com.benaya.assignments.clientapi.service;

import com.benaya.assignments.clientapi.exception.IpGeoLocationNotFoundException;
import com.benaya.assignments.clientapi.model.IpGeoLocation;
import com.benaya.assignments.clientapi.repository.IpGeoLocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class IpGeoLocationService {

    private final IpGeoLocationRepository ipGeoLocationRepository;
    private final RestTemplate restTemplate;

    public void addIpGeoLocation(String ip) {
        IpGeoLocation ipGeoLocation = restTemplate
                .getForObject("/json/"+ip, IpGeoLocation.class);
        ipGeoLocationRepository.save(Objects.requireNonNull(ipGeoLocation));
    }

    @Retryable(retryFor = {HttpClientErrorException.class,
            ResourceAccessException.class},
            maxAttempts = 10,
            backoff = @Backoff(delay = 1000, multiplier = 2))
    public void addBatchIpGeoLocations(List<String> ips) {
        HttpEntity<List<String>> ipsEntity = new HttpEntity<>(ips);
        ResponseEntity<List<IpGeoLocation>> listResponseEntity = restTemplate.exchange("/batch", HttpMethod.POST, ipsEntity, new ParameterizedTypeReference<>() {
        });
        ipGeoLocationRepository.saveAll(Objects.requireNonNull(listResponseEntity.getBody()));
    }

    public IpGeoLocation getIpGeoLocation(String ip) {
        return ipGeoLocationRepository.findById(ip).orElseThrow(IpGeoLocationNotFoundException::new);
    }
}
