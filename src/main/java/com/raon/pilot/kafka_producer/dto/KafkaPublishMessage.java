package com.raon.pilot.kafka_producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
public record KafkaPublishMessage (
        String name,
        Date birthDate,
        Integer age,
        String message
){
}
