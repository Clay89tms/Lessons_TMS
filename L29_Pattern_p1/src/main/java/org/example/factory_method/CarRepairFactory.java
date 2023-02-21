package org.example.factory_method;

import java.util.Date;

class CarRepairFactory {

    public STO_Garaje create(){
        STO_Garaje garaje = STO_Garaje.builder()
                .numberGate("1")
                .car(Car.builder()
                        .vinCode("Qwerty123456".toUpperCase())
                        .color("Silver")
                        .type("Acura")
                        .build())
                .date(new Date())
                .coast("4500")
                .build();
        System.out.println(garaje.toString());

        return garaje;
    }
}
