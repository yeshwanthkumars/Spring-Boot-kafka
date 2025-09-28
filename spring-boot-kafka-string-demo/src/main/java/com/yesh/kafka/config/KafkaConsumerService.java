package com.yesh.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	// Getting information from the Kafka Topic
	@KafkaListener(topics = "YeshwanthStringTopic", groupId = "yeshwanth-group")
	public void listenToKafkaTopic(String messageReceived) {
		System.out.println("Message received is " + messageReceived);
	}

}
