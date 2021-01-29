package io.ccoltx.spring.boot.kafka.json.simple.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TestObject {
    private String value1;

    private Integer value2;
}
