package org.example.dz30;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
class CarsImpl implements CarInterface {

    public CarsImpl(String id, String type, String color, String price) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    private String id;
    private String type;
    private String color;
    private String price;

    public CarsImpl() {
    }


    @Override
    public CarsImpl save(CarsImpl car) {
        return car;
    }

    @Override
    public void load() {

    }
}
