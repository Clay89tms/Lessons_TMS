package org.tms.dz32;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private List<Horse> horse;
    private List<Rider> rider;

    public static final List<Pair> pairs = new ArrayList<>();

    private int overallSpeed;

    public Pair() {
    }


    public void savePairs() {
        if (horse.size() == rider.size()){
            System.out.println("How match pair: " +  horse.size());

            for (int i = 0; i < (horse.size()); i++) {

            }

        }


        horse.forEach(horse1 -> horse1.takeHorse());
        rider.forEach(rider1 -> rider1.takeRider());
        horse.get(0).getSpeed();
        System.out.println();

    }

    public List<Horse> getHorse() {
        return horse;
    }

    public void setHorse(List<Horse> horse) {
        this.horse = horse;
    }

    public List<Rider> getRider() {
        return rider;
    }

    public void setRider(List<Rider> rider) {
        this.rider = rider;
    }

    public int getOverallSpeed() {
        return overallSpeed;
    }

    public void setOverallSpeed(int overallSpeed) {
        this.overallSpeed = overallSpeed;
    }
}

