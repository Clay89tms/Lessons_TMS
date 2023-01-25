package org.example.dz30;

 class MainApp {
     public static void main(String[] args) {
         CarInterface carSave = new CarsCacheImpl(new CarsDataBaseImpl(new CarsImpl()));
         CarsImpl car;

         car = new CarsImpl("1", "Acura", "Silver", "12000");
         System.out.println(car);
         carSave.save(car);

         car = new CarsImpl("2", "Honda", "red", "10000");
         System.out.println(car);
         carSave.save(car);

         car = new CarsImpl("3", "33", "33", "33");
         System.out.println(car);
         carSave.save(car);

         car = new CarsImpl("1", "44", "44", "44");
         System.out.println(car);
         carSave.save(car);

         car = new CarsImpl("5", "55", "55", "55");
         System.out.println(car);
         carSave.save(car);

         System.out.println(car.getId());
     }
}
