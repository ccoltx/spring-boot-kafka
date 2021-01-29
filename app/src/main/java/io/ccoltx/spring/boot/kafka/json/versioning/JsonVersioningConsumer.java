package io.ccoltx.spring.boot.kafka.json.versioning;

import java.util.concurrent.atomic.AtomicInteger;

import io.ccoltx.spring.boot.kafka.json.versioning.data.TestObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json-versioning")
public class JsonVersioningConsumer {

    @KafkaListener( topics = {"${test.topic:test-topic}"})
    public void listen(ConsumerRecord<String, TestObject> record) {
        System.out.println("The record:" + record);
    }

}
