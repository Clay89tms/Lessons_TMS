package org.example.factory_method;

import java.util.Date;

public class CarRepairFactoryImpl implements Factory<Car> {

    @Override
    public Car create() {
        STO_Garaje garaje = STO_Garaje.builder()
                .numberGate("2")
                .car(Car.builder()
                        .vinCode("Qwerty123456")
                        .color("Red")
                        .type("Honda")
                        .build())
                .date(new Date())
                .coast("2300")
                .build();
        System.out.println(garaje.toString());
        return garaje.getCar();
    }
}