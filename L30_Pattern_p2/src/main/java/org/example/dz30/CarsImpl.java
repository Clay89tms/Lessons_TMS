package org.example.dz30;

import lombok.Getter;
import lombok.Setter;

@Getter
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
    public CarsImpl save(CarsImpl cars) {
        return cars;
    }

    @Override
    public void load() {

    }
}
