# spring-boot-kafka

[![Apache License 2](https://img.shields.io/badge/license-ASF2-blue.svg)](https://github.com/ccoltx/spring-boot-kafka/LICENSE.md)
[![Build Status](https://github.com/ccoltx/spring-boot-kafka/workflows/build/badge.svg)](https://github.com/ccoltx/spring-boot-kafka/actions)

Welcome to my sample Spring Boot Kafka project. This project contains various producer and subscriber scenarios, detailed below.

## Scenarios

### String Values
Kafka publish and consume string values.

### JSON Value
Kafka publish and consume JSON values. Standard configuration.

### JSON Versioning
Kafka publish and consume JSON values. Objects are versioned, that is, the Producer sends V1 and V2, and a single
Consumer can handle both versions.

### No Type ID
Kafka publish and consume JSON values. Objects are versioned, that is, the Producer sends V1 and V2, and a single
Consumer can handle both versions. However, the following property `spring.json.add.type.headers=false` is configured,
which disables the Producer from sending the TYPE_ID of the serialized object. The consumer does not know how to deserialize the value.