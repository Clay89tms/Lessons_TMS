package org.tms.dz32;

public class Horse {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public Horse() {
    }

    public int takeHorse() {
        //задаем рандом скорость от 1 до 10
        return this.speed = (int) (1 + Math.random() * 10);
//        System.out.println("Speed horse: " + this.speed + " m/s");
    }
}
