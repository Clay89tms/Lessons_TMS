package org.example.observer;

import java.util.Observable;

public class CreateServiceObserver extends Observable implements UserService{

    private String serviceName = "create";

    public void createPerson(User user) {
        System.out.println("save user");
        setChanged();
        notifyObservers(user);
    }

    public String getServiceName() {
        return serviceName;
    }
}
