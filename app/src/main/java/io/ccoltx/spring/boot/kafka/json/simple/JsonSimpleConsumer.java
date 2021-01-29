package io.ccoltx.spring.boot.kafka.json.simple;

import java.util.concurrent.atomic.AtomicInteger;

import io.ccoltx.spring.boot.kafka.json.simple.data.TestObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json-simple")
public class JsonSimpleConsumer {

    public static AtomicInteger count = new AtomicInteger();

    @KafkaListener( topics = {"${test.topic:test-topic}"})
    public void listen(ConsumerRecord<String, TestObject> record) {

        System.out.println("The record:" + record);

        count.incrementAndGet();
    }

}
