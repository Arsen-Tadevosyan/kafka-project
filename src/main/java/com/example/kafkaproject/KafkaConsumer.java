package com.example.kafkaproject;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consume(KafkaController.Message message) {
        System.out.println("Consumed message: " + message.getContent() + " at " + message.getTimestamp());
    }
}