package org.tms.dz32;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private Horse horse;
    private Rider rider;


    public Pair(Horse horse, Rider rider) {
        System.out.println("pair const");
        this.horse = horse;
        this.rider = rider;
    }

    public void createPartner() {
        rider.takeRider();
        horse.takeHorse();
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "horse=" + horse +
                ", rider=" + rider +
                '}';
    }
}

