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
        boolean b = true;

        for (int i = 0; i < carsCache.size(); i++) {
            if (carsCache.get(i).getId().equals(car.getId())) {
                System.out.println("this car is already in the Cache! break");
                b = false;
                break;
            }
        }

        if (b) {
            carInterface.save(car);
            if (carsCache.size() >= 2) {
                System.out.println("remove car in Cache with id = " + carsCache.get(0).getId());
                carsCache.remove(0);
            }

            carsCache.add(car);
            System.out.println("Car add to Cache with id = " + car.getId());
        }
        System.out.println();
        return car;
    }

    @Override
    public CarsImpl load(String id) {
        CarsImpl car = null;
        for (int i = 0; i < carsCache.size(); i++) {
            if (carsCache.get(i).getId().equals(id)) {
                car = carsCache.get(i);
                System.out.println("load car in Cache; id = " + id);
                break;
            }
        }
        if (car == null) {
            System.out.println("don't find car in Cache");
            car = carInterface.load(id);
            if (car != null) {
                if (carsCache.size() >= 2) {
                    System.out.println("remove car in Cache with id = " + carsCache.get(0).getId());
                    carsCache.remove(0);
                }
                carsCache.add(car);
            }
        }
        System.out.println();
        return car;
    }

    @Override
    public void delete(String id) {
        try {
            carInterface.delete(id);

            boolean b = true;
            for (int i = 0; i < carsCache.size(); i++) {
                if (id.equals(carsCache.get(i).getId())) {
                    System.out.println("delete car in Cache");
                    carsCache.remove(i);
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println("don't find car in Cache");
            }
        } catch (RuntimeException runtimeException) {
            System.out.println("go out in Cache");
        }
        System.out.println();
    }

    @Override
    public CarsImpl update(CarsImpl car) {
        CarsImpl update = carInterface.update(car);
        if (update != null){
            boolean b = true;

            for (int i = 0; i < carsCache.size(); i++) {
                if (carsCache.get(i).getId().equals(car.getId())) {
                    if (carsCache.size() >= 2) {
                        System.out.println("remove car in Cache with id = " + carsCache.get(0).getId());
                        carsCache.remove(0);
                    } else {
                        System.out.println("remove car in Cache with id = " + carsCache.get(i).getId());
                        carsCache.remove(i);
                    }
                    System.out.println("add car in Cache with id = " + car.getId());
                    carsCache.add(car);
                    b = false;
                    break;
                }
            }

            if (b) {
                System.out.println("car don't find in Cache to id = " + car.getId());
            }
        }

        return update;
    }
}
