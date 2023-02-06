package org.tms.dz32;

public class Pair {

    private Horse horse;
    private Rider rider;

    private int overallSpeed;

    public Pair() {
    }


    public void savePair(int nomberPair) {
        System.out.println("This is Pair# " + nomberPair);
        horse.takeHorse();
        rider.takeRider();

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

    public int getOverallSpeed() {
        return overallSpeed;
    }

    public void setOverallSpeed(int overallSpeed) {
        this.overallSpeed = overallSpeed;
    }
}

