package com.example.kafkaproject;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "test-topic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message published successfully!";
    }

    @Data
    public static class Message {
        private String content;
        private String timestamp;
    }
}
