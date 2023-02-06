package org.tms.dz32;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private List<Horse> horse;
    private List<Rider> rider;

    public static final List<Integer> pairs = new ArrayList<>();


    public Pair() {
    }


    public void createPairs() {
        if (horse.size() == rider.size()) {
            System.out.println("How match pair: " + horse.size());

            for (int i = 0; i < (horse.size()); i++) {
                int riderLevel = rider.get(i).takeRider();
                int horseSpeed = horse.get(i).takeHorse();

                int overallSpeed = horseSpeed * ((int) (1 + Math.random() * riderLevel));
                System.out.println("horse speed = " + horseSpeed +
                        "; rider level = " + riderLevel +
                        "; overall speed pair# " + (i + 1) +
                        " = " + overallSpeed);
                pairs.add(overallSpeed);
            }
        }
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

}

