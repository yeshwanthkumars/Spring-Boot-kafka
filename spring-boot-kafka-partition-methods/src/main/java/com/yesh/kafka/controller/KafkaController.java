package com.yesh.kafka.controller;

import org.springframework.web.bind.annotation.*;

import com.yesh.kafka.config.PartitionProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final PartitionProducer producer;

	public KafkaController(PartitionProducer producer) {
		this.producer = producer;
	}

	@GetMapping("/direct/{partition}/{message}")
	public String sendDirect(@PathVariable int partition, @PathVariable String message) {
		producer.sendToSpecificPartition(message, partition);
		return "Message sent directly to partition " + partition;
	}

	@GetMapping("/key/{key}/{message}")
	public String sendWithKey(@PathVariable String key, @PathVariable String message) {
		producer.sendWithKey(key, message);
		return "Message sent with key: " + key;
	}

	@GetMapping("/round/{message}")
	public String sendRoundRobin(@PathVariable String message) {
		producer.sendWithoutKey(message);
		return "Message sent without key (round-robin)";
	}
}
