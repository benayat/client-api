package com.benaya.assignments.clientapi.controller;

import com.benaya.assignments.clientapi.model.IpGeoLocation;
import com.benaya.assignments.clientapi.service.IpGeoLocationService;
import com.benaya.assignments.clientapi.validate.annotations.ValidIpV4Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ipGeoLocation")
@RequiredArgsConstructor
public class IpGeoLocationController {
    private final IpGeoLocationService ipGeoLocationService;

    @GetMapping("by-ip")
    public IpGeoLocation getIpGeoLocation(@RequestParam @ValidIpV4Address String ip) {
        return ipGeoLocationService.getIpGeoLocation(ip);
    }

}
