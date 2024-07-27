package com.kafka.demo.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    public LocationService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean uplodateLocation(String location){
        kafkaTemplate.send("cab-location", location);
        return true;
    }
}
