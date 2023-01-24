package org.example.dz30;

class CarsCacheImpl implements CarInterface {

    public CarInterface carInterface;

    public CarsCacheImpl(CarInterface carInterface) {
        this.carInterface = carInterface;
    }

    @Override
    public CarsImpl save(CarsImpl cars) {
        carInterface.save(cars);
        return cars;
    }

    @Override
    public void load() {

    }
}
