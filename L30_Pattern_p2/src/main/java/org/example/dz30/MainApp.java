package org.example.dz30;

 class MainApp {
     public static void main(String[] args) {
         CarInterface carService = new CarsCacheImpl(new CarsDataBaseImpl(new CarsImpl()));
         CarsImpl car;

         car = new CarsImpl("3", "Acura", "Silver", "12000");
         System.out.println(car);
         carService.save(car);

         car = new CarsImpl("2", "Honda", "red", "10000");
         System.out.println(car);
         carService.save(car);

         car = new CarsImpl("1", "33", "33", "33");
         System.out.println(car);
         carService.save(car);

         car = new CarsImpl("3", "33", "33", "33");
         System.out.println(car);
         carService.save(car);

         car = new CarsImpl("2", "Honda", "red", "10000");
         System.out.println(car);
         carService.save(car);

         System.out.println("loading car id = 1");
         CarsImpl load = carService.load("1");
         System.out.println(load);

         System.out.println(car.getId());
     }
}
