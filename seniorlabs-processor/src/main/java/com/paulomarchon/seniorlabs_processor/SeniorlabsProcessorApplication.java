package com.paulomarchon.seniorlabs_processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableFeignClients
@EnableKafka
public class SeniorlabsProcessorApplication {

	private static final Logger log = LoggerFactory.getLogger(SeniorlabsProcessorApplication.class);
	private final LegacySystemClient legacySystemClient;

    public SeniorlabsProcessorApplication(LegacySystemClient legacySystemClient) {
        this.legacySystemClient = legacySystemClient;
    }

	public static void main(String[] args) {
		SpringApplication.run(SeniorlabsProcessorApplication.class, args);
	}

	@KafkaListener(topics = "clock-registers", groupId = "clock")
	public void processToLegacySystem(PunchClockDto punchClockDto) {
		var response = legacySystemClient.sendToLegacySystem(punchClockDto);
		log.info("Response from legacy system: {}", response);
	}
}
