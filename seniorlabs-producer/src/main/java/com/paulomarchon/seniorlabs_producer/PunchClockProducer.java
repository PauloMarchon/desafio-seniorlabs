package com.paulomarchon.seniorlabs_producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PunchClockProducer {
    private static final Logger log = LoggerFactory.getLogger(PunchClockProducer.class);
    private final KafkaTemplate<String, PunchClockDto> kafkaTemplate;

    public PunchClockProducer(KafkaTemplate<String, PunchClockDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PunchClockDto dto) {
        Message<PunchClockDto> message = MessageBuilder
                .withPayload(dto)
                .setHeader(KafkaHeaders.TOPIC, "clock-registers")
                .build();
        log.info("Sending message: {}", message);
        kafkaTemplate.send(message);
    }
}
