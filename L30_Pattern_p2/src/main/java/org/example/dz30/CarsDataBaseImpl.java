package org.example.dz30;

 class CarsDataBaseImpl implements CarInterface {

  private CarInterface carInterface;

  public CarsDataBaseImpl(CarInterface carInterface) {
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
