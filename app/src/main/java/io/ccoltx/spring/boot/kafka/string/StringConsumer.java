package io.ccoltx.spring.boot.kafka.string;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-string")
public class StringConsumer {

    @KafkaListener( topics = {"${test.topic:test-topic}"})
    public void listen(ConsumerRecord<String, String> record) {

    }
}
