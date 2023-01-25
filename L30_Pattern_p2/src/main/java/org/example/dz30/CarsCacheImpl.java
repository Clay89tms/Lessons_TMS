package org.example.dz30;

import java.util.ArrayList;
import java.util.List;

class CarsCacheImpl implements CarInterface {

    private List<CarsImpl> carsCache = new ArrayList<>();

    public CarInterface carInterface;

    public CarsCacheImpl(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    @Override
    public CarsImpl save(CarsImpl car) {
        carInterface.save(car);
        if (carsCache.size() >= 2) {
            System.out.println("remove car with id = " + carsCache.get(0).getId());
            carsCache.remove(0);

        }
        if (carsCache.isEmpty()) {
            carsCache.add(car);
            System.out.println("Car add to Cache with id = " + car.getId());
        } else {
            for (int i = 0; i < carsCache.size(); i++) {
                if (carsCache.get(i).getId().equals(car.getId())) {
                    System.out.println("this car is already in the Cache!");
                    break;
                } else {
                    carsCache.add(car);
                    System.out.println("Car add to Cache with id = " + car.getId());
                    break;
                }
            }
        }

        return car;
    }

    @Override
    public void load() {

    }
}
