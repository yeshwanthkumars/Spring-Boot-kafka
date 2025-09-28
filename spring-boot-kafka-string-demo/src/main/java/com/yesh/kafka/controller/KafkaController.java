package com.yesh.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.kafka.config.KafkaProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

	private KafkaProducerService kafkaProducer;

	public KafkaController(KafkaProducerService kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/send")
	public String sendMessage(String message) {
		kafkaProducer.sendMessageToTopic(message);
		LOGGER.info("Message sent Successfully to the kafka Topic.." + message);
		return "Message sent Successfully to the kafka Topic..";

	}

}
