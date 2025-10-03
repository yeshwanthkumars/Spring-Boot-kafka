package com.yesh.kafka.controller;

import org.springframework.web.bind.annotation.*;

import com.yesh.kafka.producer.MessageProducer;

@RestController
@RequestMapping("/kafka")
public class MessageController {

	private final MessageProducer producer;

	public MessageController(MessageProducer producer) {
		this.producer = producer;
	}

	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable String message) {
		producer.sendMessage(message);
		return "Message sent: " + message;
	}
}
