package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public UserController(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/users/{message}")
    public String sendMessage(@PathVariable String message) {
        for (int i = 0; i < 10; i++) {
            int key = i % 2;
            kafkaTemplate.send(topicName, key, message + "-" + i);
        }
        return "Messages sent to Kafka topic: " + topicName;
    }
}
