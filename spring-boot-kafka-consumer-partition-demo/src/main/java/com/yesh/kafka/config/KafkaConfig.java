package com.yesh.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {

		return new NewTopic("demo-topic", 3, (short) 1);

	}

}
