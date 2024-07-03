package com.paulomarchon.seniorlabs_processor;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("clock-registers")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
