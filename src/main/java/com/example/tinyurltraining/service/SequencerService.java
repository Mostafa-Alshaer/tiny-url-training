package com.example.tinyurltraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SequencerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${sequencer.url}")
    private String sequencerServiceURI;

    public Long getNextNumber(){
        return restTemplate.getForObject(sequencerServiceURI, Long.class);
    }
}
