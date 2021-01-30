package io.ccoltx.spring.boot.kafka.json.no_type_id;

import io.ccoltx.spring.boot.kafka.json.no_type_id.data.TestObject;
import io.ccoltx.spring.boot.kafka.json.no_type_id.data.v1.TestObjectV1;
import io.ccoltx.spring.boot.kafka.json.no_type_id.data.v2.TestObjectV2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Testcontainers
@ActiveProfiles("kafka-json-notypeid")
@Disabled("Until I have time to complete the test")
class KafkaJsonNoTypeIdTest {

    @Container
    private static final KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));

    @Autowired
    private JsonNoTypeIdProducer producer;

    @SpyBean
    private JsonNoTypeIdConsumer consumer;

    @Value("${test.topic:test-topic}")
    private String topic;

    @Captor
    private ArgumentCaptor<ConsumerRecord<String, TestObject>> argumentCaptor;

    @DynamicPropertySource
    static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
    }

    @Test
    void testV1() {

        TestObjectV1 testObj = TestObjectV1.builder().value1("Test value 1").value2(99).build();

        producer.send(topic, testObj);

        // Verify the consumer's KafkaListener was called at all
        await().atMost(5, SECONDS).untilAsserted(() ->verify(consumer).listen(argumentCaptor.capture()));

        // Verify the test message was received
        assertThat(argumentCaptor.getValue().value()).isEqualTo(testObj);
    }

    @Test
    void testV2() {

        TestObjectV2 testObj = TestObjectV2.builder().value1("Test value 2").value2(100).build();

        producer.send(topic, testObj);

        // Verify the consumer's KafkaListener was called at all
        await().atMost(5, SECONDS).untilAsserted(() -> verify(consumer).listen(argumentCaptor.capture()));

        // Verify the test message was received
        assertThat(argumentCaptor.getValue().value()).isEqualTo(testObj);
    }

}
