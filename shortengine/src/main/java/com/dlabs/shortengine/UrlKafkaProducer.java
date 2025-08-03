package com.dlabs.shortengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlKafkaProducer {

    private static final String TOPIC = "short-url-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUrlCreatedEvent(String originalUrl, String shortUrl) {
        String message = "Shortened URL created: " + originalUrl + " -> " + shortUrl;
        kafkaTemplate.send(TOPIC, message);
        System.out.println("🚀 Kafka - Event sent: " + message);
    }
}
