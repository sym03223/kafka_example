package com.raon.pilot.kafka_producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raon.pilot.kafka_producer.dto.KafkaRequestMessage;
import com.raon.pilot.kafka_producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/publish-msg")
    public ResponseEntity createMessage(@RequestBody KafkaRequestMessage kafkaRequestMessage)
            throws JsonProcessingException {
        producerService.create(kafkaRequestMessage.topic(), kafkaRequestMessage.message());

        return ResponseEntity.ok().build();
    }
}
