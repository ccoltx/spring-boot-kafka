package io.ccoltx.spring.boot.kafka.json.versioning.data.v2;

import io.ccoltx.spring.boot.kafka.json.versioning.data.TestObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TestObjectV2 implements TestObject {
    private String value1;
    private Integer value2;
}
