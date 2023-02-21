package org.example.mediator;

public class ServiceHandler {

    public void process(){

        Service1 service1 = new Service1();
        service1.print();

        Service2 service2 = new Service2();
        service2.print();

        Service3 service3 = new Service3();
        service3.print();

    }

}
