package com.yesh.kafka.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PartitionProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String topic = "partition-demo";

	public PartitionProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	// 1. Direct Partition
	public void sendToSpecificPartition(String message, int partition) {
		kafkaTemplate.send(topic, partition, null, message);
		System.out.println("Sent [" + message + "] to partition " + partition);
	}

	// 2. Key-based Partitioning
	public void sendWithKey(String key, String message) {
		kafkaTemplate.send(topic, key, message);
		System.out.println("Sent [" + message + "] with key [" + key + "]");
	}

	// 3. Round Robin (no key, no partition)
	public void sendWithoutKey(String message) {
		kafkaTemplate.send(topic, message);
		System.out.println("Sent [" + message + "] with no key (round-robin)");
	}

}
