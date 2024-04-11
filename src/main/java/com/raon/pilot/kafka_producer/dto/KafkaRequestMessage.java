package com.raon.pilot.kafka_producer.dto;


public record KafkaRequestMessage(
    String topic,
    String message
) {
}
