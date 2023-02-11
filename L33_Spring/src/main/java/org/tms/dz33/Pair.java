package org.tms.dz33;

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
}

