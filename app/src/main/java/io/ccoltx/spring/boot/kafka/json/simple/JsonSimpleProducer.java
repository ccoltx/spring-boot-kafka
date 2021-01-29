package io.ccoltx.spring.boot.kafka.json.simple;

import io.ccoltx.spring.boot.kafka.json.simple.data.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json-simple")
public class JsonSimpleProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonSimpleProducer.class);

    @Autowired
    private KafkaTemplate<String, TestObject> kafkaTemplate;

    public void send(String topic, TestObject payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);

        for (int i = 0; i < 1; i++) {
            kafkaTemplate.send(topic, Integer.toString(i), payload);
        }
        kafkaTemplate.flush();
    }
}
