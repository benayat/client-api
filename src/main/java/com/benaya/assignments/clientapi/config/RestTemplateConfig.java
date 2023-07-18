package com.benaya.assignments.clientapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.retry.support.RetryTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    @Value("${ip-api.baseurl}")
    private String ipApiBaseUrl;
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new  RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(ipApiBaseUrl));
        return restTemplate;
    }
}
