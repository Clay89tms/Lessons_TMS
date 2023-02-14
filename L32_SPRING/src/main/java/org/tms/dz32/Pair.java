package org.tms.dz32;

public class Pair {

    private Horse horse;
    private Rider rider;
    private int overSpeed=0;


    public Pair(Horse horse, Rider rider) {
        System.out.println("pair const");
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

    @Override
    public String toString() {
        return "Pair{" +
                "horse=" + horse +
                ", rider=" + rider +
                ", overSpeed=" + overSpeed +
                '}';
    }
}

