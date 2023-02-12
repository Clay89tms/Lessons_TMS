package org.example.builder_lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class Car {
    private String vinCode;
    private String type;
    private String color;
}
