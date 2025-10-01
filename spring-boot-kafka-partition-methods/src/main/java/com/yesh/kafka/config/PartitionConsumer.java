package com.yesh.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PartitionConsumer {

    @KafkaListener(topics = "partition-demo", groupId = "partition-demo-group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message: " + record.value() +
                           " from partition: " + record.partition() +
                           " with key: " + record.key());
    }
}