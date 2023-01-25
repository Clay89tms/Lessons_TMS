package org.example.dz30;

import java.util.ArrayList;
import java.util.List;

class CarsDataBaseImpl implements CarInterface {

    private List<CarsImpl> carsDataBase = new ArrayList<>();

    private CarInterface carInterface;

    public CarsDataBaseImpl(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    @Override
    public CarsImpl save(CarsImpl car) {
        carInterface.save(car);

        if (carsDataBase.isEmpty()) {
            carsDataBase.add(car);
            System.out.println("Car add to DataBase with id = " + car.getId());
        } else {
            for (int i = 0; i < carsDataBase.size(); i++) {
                if (carsDataBase.get(i).getId().equals(car.getId())) {
                    System.out.println("this car is already in the DataBase!");
                    break;
                } else {
                    carsDataBase.add(car);
                    System.out.println("Car add to DataBase with id = " + car.getId());
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
