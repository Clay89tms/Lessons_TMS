package org.example.dz30;

import java.util.ArrayList;
import java.util.List;

class CarsDataBaseImpl implements CarInterface {

    private List<CarsImpl> carsDataBase = new ArrayList<>();

    private CarInterface carInterface;

    public CarsDataBaseImpl() {
    }

    @Override
    public CarsImpl save(CarsImpl car) {
        if (carsDataBase.isEmpty()) {
            carsDataBase.add(car);
            System.out.println("Car add to DataBase with id = " + car.getId());
        } else {
            boolean b = true;
            for (int i = 0; i < carsDataBase.size(); i++) {
                if (carsDataBase.get(i).getId().equals(car.getId())) {
                    System.out.println("this car is already in the DataBase!");
                    b = false;
                    break;
                }
            }
            if (b) {
                carsDataBase.add(car);
                System.out.println("Car add to DataBase with id = " + car.getId());
            }
        }
        return car;
    }

    @Override
    public CarsImpl load(String id) {
        CarsImpl cars = null;
        for (int i = 0; i < carsDataBase.size(); i++) {
            if (carsDataBase.get(i).getId().equals(id)) {
                System.out.println("load car DB; id = " + id);
                cars = carsDataBase.get(i);
                break;
            }
        }
        if (cars == null) {
            System.out.println("don't find car in DB");
        }
        return cars;
    }

    @Override
    public void delete(String id) {
        boolean b = true;
        for (int i = 0; i < carsDataBase.size(); i++) {
            if (id.equals(carsDataBase.get(i).getId())) {
                System.out.println("delete car in DataBase");
                carsDataBase.remove(i);
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("don't find car in DB");
            throw new RuntimeException();
        }
    }

    @Override
    public CarsImpl update(CarsImpl car) {
        CarsImpl update = null;
        for (int i = 0; i < carsDataBase.size(); i++) {
            if (carsDataBase.get(i).getId().equals(car.getId())) {
                if (car.getType().equals(carsDataBase.get(i).getType()) &&
                        car.getColor().equals(carsDataBase.get(i).getColor()) &&
                        car.getPrice().equals(carsDataBase.get(i).getPrice())) {
                    System.out.println("This car already in DB. return (car)");
                    update = car;
                    return update;
                } else {
                    System.out.println("update car in DB to id = " + car.getId());
                    carsDataBase.remove(i);
                    carsDataBase.add(car);
                   update = car;
                   return update;
                }
            } else {
                System.out.println("car don't find in DB to id = " + car.getId());
                break;
            }
        }
        return update;
    }
}