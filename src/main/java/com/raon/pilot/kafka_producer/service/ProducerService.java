package com.raon.pilot.kafka_producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raon.pilot.kafka_producer.dto.KafkaPublishMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
@RestController
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void create(String topic, String message) throws JsonProcessingException {
        KafkaPublishMessage kafkaPublishMessage = KafkaPublishMessage.builder()
                        .name("name")
                        .age(12)
                        .message(message)
                        .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = objectMapper.writeValueAsString(kafkaPublishMessage);
        kafkaTemplate.send(topic, msg);
    }
}
