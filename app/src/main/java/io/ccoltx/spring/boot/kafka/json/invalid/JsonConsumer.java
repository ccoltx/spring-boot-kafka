package io.ccoltx.spring.boot.kafka.json.invalid;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json")
public class JsonConsumer<T> {

    public static AtomicInteger count = new AtomicInteger();

    @KafkaListener( topics = {"${test.topic:test-topic}"})
    public void listen(ConsumerRecord<String, T> record) {

        System.out.println("The record:" + record);

        count.incrementAndGet();
    }
}
