package org.tms.dz32;

public class Pair {

    private Horse horse;
    private Rider rider;
    private int overSpeed = 0;
    private int numberPair;


    public Pair(Horse horse, Rider rider, int numberPair) {
        System.out.println("pair const");
        this.numberPair = numberPair;
        this.horse = horse;
        this.rider = rider;
        this.overSpeed = 0;
    }

    public void createPartner() {
        rider.takeRider();
        horse.takeHorse();
        this.overSpeed = 0;
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

    public int getOverSpeed() {
        return overSpeed;
    }

    public void setOverSpeed(int overSpeed) {
        this.overSpeed = overSpeed;
    }

    public int getNumberPair() {
        return numberPair;
    }

    public void setNumberPair(int numberPair) {
        this.numberPair = numberPair;
    }

    @Override
    public String toString() {
        return "Pair# " + numberPair + " | horse=" + horse.getSpeed() +
                ", rider=" + rider.getLevel();
    }
}

