package com.yesh.kafka.consumer;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "demo_topic", groupId = "group_id_demo")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }

    // You can add multiple listeners with different groupIds
    @KafkaListener(topics = "demo_topic", groupId = "another_group")
    public void consumeMessageInAnotherGroup(String message) {
        System.out.println("Another consumer received: " + message);
    }
}

