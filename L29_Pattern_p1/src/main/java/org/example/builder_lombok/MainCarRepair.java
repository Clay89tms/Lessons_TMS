package org.example.builder_lombok;

import lombok.Data;
import org.example.builder_lombok.STO_Garaje;
import org.example.builder_lombok.Book_Lombok;

import java.util.Date;

public class MainCarRepair {
    public static void main(String[] args) {


        STO_Garaje garaje = STO_Garaje.builder()
                .numberGate("1")
                .car(Car.builder()
                        .vinCode("QWERTY123456")
                        .color("Silver")
                        .type("Acura")
                        .build())
                .date(new Date())
                .coast("4500")
                .build();
        System.out.println(garaje.toString());
    }
}
