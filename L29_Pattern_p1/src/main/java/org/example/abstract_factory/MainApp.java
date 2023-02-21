package org.example.abstract_factory;

public class MainApp {
    public static void main(String[] args) {

        String type = "Infinity";

        MainService service = new MainService();
        service.createCar(new MersAbstractFactoryImpl() );

    }
}
