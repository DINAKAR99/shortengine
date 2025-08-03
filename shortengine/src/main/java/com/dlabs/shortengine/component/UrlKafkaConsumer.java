package com.dlabs.shortengine.component;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UrlKafkaConsumer {

    @KafkaListener(topics = "short-url-events", groupId = "short-url-group")
    public void listen(String message) {
        System.out.println("📥 Kafka - Event received: " + message);
    }
}
