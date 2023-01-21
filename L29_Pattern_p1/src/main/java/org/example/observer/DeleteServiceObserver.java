package org.example.observer;

import java.util.Observable;

public class DeleteServiceObserver extends Observable implements UserService{

    private String serviceName = "delete";

    public void deletePerson(User user) {
        System.out.println("delete user");
        setChanged();
        notifyObservers(user);
    }

    public String getServiceName() {
        return serviceName;
    }
}
