package org.example.dz30;

 class MainApp {
     public static void main(String[] args) {
         CarsImpl cars = new CarsImpl("1", "Acura", "Silver", "12000");
         CarInterface carSave = new CarsCacheImpl(new CarsDataBaseImpl(new CarsImpl()));
         carSave.save(cars);
     }
}
