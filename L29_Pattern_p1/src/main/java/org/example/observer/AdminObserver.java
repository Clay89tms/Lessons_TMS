package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class AdminObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        User userName = (User) arg;
        System.out.println("This admin man");
        System.out.println("prepare PC for " + userName.getName());
    }
}
