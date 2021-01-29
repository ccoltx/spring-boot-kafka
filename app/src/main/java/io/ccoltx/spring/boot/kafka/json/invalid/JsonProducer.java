package io.ccoltx.spring.boot.kafka.json.invalid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("kafka-json")
public class JsonProducer<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    public void send(String topic, T payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);

        for (int i = 0; i < 1; i++) {
            kafkaTemplate.send(topic, Integer.toString(i), payload);
        }
        kafkaTemplate.flush();
    }
}
