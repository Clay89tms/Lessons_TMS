package org.tms.dz33.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Horse {
    private int speed;

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
}
