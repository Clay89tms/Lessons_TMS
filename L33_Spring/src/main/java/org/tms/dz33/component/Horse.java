package org.tms.dz33.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
public class Horse {
    private int speed;

    private String nameHorse;

    public Horse() {
        System.out.println("horse const");
    }

    public void takeHorse() {
        //задаем рандом скорость от 1 до 10
        this.speed = (int) (1 + Math.random() * 10);
//        System.out.println("Speed horse: " + this.speed + " m/s");
    }
    public int getSpeed() {
        return speed;
    }

    public String getNameHorse() {
        return nameHorse;
    }

    public void setNameHorse(String nameHorse) {
        this.nameHorse = nameHorse;
    }
}
