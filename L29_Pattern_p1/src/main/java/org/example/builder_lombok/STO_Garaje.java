package org.example.builder_lombok;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Builder
@Data
@ToString
class STO_Garaje {
    private String numberGate;
    private Car car;
    private Date date;
    private String coast;
}
