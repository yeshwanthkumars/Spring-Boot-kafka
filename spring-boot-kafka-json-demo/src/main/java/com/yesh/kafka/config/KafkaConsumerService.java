package com.yesh.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yesh.kafka.model.User;

@Service
public class KafkaConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "yeshwanthTopic", groupId = "yeshwanth-group")
	public void consume(User user) {
		LOGGER.info(String.format("Json message received -> %s", user.toString()));
	}

}
