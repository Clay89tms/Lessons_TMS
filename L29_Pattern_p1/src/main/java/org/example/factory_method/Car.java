package org.example.factory_method;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class Car {
    private String vinCode;
    private String type;
    private String color;
}
