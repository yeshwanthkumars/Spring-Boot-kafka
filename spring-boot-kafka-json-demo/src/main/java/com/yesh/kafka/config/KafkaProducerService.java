package com.yesh.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.yesh.kafka.model.User;

@Service
public class KafkaProducerService {

	@Value("${kafka.topic.name}")
	private String topic;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	// Injecting kafka template using constructor injection
	public KafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	// Sending message to the kafka topic
	public void sendMessageToTopic(User user) {
        LOGGER.info("Producing user event -> {}", user);
        kafkaTemplate.send(topic, user);
    }
}
