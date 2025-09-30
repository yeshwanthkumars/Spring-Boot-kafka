package com.yesh.kafka;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yesh.kafka.producer.MessageProducer;

@SpringBootApplication
public class SpringBootKafkaConsumerPartitionDemoApplication implements CommandLineRunner {
    
    private final MessageProducer producer;

    // Constructor injection
    public SpringBootKafkaConsumerPartitionDemoApplication(MessageProducer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaConsumerPartitionDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Send 10 messages
        for (int i = 1; i <= 10; i++) {
            producer.sendMessage("Message-" + i);
        }
    }
}

