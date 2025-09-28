package com.yesh.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	// Injecting kafka template using constructor injection
	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	// Sending message to the kafka topic
	public void sendMessageToTopic(String message) {
		kafkaTemplate.send("YeshwanthStringTopic", message);
	}

}
