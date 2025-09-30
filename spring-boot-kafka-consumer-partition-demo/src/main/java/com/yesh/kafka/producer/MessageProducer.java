package com.yesh.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public MessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		// Send to topic "demo-topic"
		kafkaTemplate.send("demo-topic", message);
		System.out.println("Produced message: " + message);
	}
}