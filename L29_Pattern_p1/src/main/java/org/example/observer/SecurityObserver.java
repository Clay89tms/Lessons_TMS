package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class SecurityObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        UserService service = (UserService) o;

        User userName = (User) arg;
        System.out.println("This id security man");

        if(service.getServiceName().equals("create")){
            System.out.println("prepare id card for " + userName.getName());
        } else if (service.getServiceName().equals("delete")) {
            System.out.println("delete id card");
        }

    }
}
