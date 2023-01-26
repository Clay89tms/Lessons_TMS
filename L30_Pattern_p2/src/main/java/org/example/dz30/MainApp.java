package org.example.dz30;

class MainApp {
    public static void main(String[] args) {
        CarInterface carService = new CarsCacheImpl(new CarsDataBaseImpl());
        String id;
        CarsImpl car;
        CarsImpl load;
        CarsImpl update;

        car = new CarsImpl("1", "Acura", "Silver", "12000");
        System.out.println(car);
        carService.save(car);

        car = new CarsImpl("2", "Honda", "red", "10000");
        System.out.println(car);
        carService.save(car);

        car = new CarsImpl("3", "33", "33", "33");
        System.out.println(car);
        carService.save(car);

        car = new CarsImpl("1", "33", "33", "33");
        System.out.println(car);
        carService.save(car);

        car = new CarsImpl("5", "Honda", "red", "10000");
        System.out.println(car);
        carService.save(car);

        id = "3";
        System.out.println("loading car id = " + id);
        load = carService.load(id);
        System.out.println(load);

        id = "5";
        System.out.println("loading car id = " + id);
        load = carService.load(id);
        System.out.println(load);

        id = "2";
        System.out.println("delete car id = " + id);
        carService.delete(id);

        id = "2";
        System.out.println("delete car id = " + id);
        carService.delete(id);

        car = new CarsImpl("1", "1", "1", "1");
        update = carService.update(car);
        System.out.println(update);
    }
}
