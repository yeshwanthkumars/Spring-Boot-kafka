package com.yesh.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesh.kafka.config.KafkaProducerService;
import com.yesh.kafka.model.User;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

	private KafkaProducerService kafkaProducer;

	public KafkaController(KafkaProducerService kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {

		LOGGER.info("Request Sending to Producer--->" + user);

		kafkaProducer.sendMessageToTopic(user);
		return ResponseEntity.ok("User Json Sent Successfully to the Topic...");
	}

}
