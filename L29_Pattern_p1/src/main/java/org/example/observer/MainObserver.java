package org.example.observer;

public class MainObserver {
    public static void main(String[] args) {

        CreateServiceObserver createServiceObserver = new CreateServiceObserver();
        DeleteServiceObserver deleteServiceObserver = new DeleteServiceObserver();

        createServiceObserver.addObserver(new SecurityObserver());
        createServiceObserver.addObserver(new SalaryObserver());
        createServiceObserver.addObserver(new AdminObserver());

        deleteServiceObserver.addObserver(new SecurityObserver());

        createServiceObserver.createPerson(new User("Roma"));
        System.out.println("----------------------");
        deleteServiceObserver.deletePerson(new User("Roma"));

    }
}
