package io.ccoltx.spring.boot.kafka.json.no_type_id;

import io.ccoltx.spring.boot.kafka.json.no_type_id.data.TestObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json-notypeid")
public class JsonNoTypeIdConsumer {

    @KafkaListener( topics = {"${test.topic:test-topic}"})
    public void listen(ConsumerRecord<String, TestObject> record) {
        System.out.println("The record:" + record);
    }

}
