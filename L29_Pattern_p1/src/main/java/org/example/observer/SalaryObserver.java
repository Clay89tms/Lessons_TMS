package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class SalaryObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        User userName = (User) arg;
        System.out.println("This id salary man");
        System.out.println("prepare salary bill for " + userName.getName());
    }
}
