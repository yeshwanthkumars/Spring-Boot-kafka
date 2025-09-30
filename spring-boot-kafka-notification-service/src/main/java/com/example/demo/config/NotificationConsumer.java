package com.example.demo.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "notification-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
