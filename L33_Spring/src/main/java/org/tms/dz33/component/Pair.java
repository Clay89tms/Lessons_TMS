package org.tms.dz33.component;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Service
public class Pair {

    private Horse horse;
    private Rider rider;
    private int overSpeed = 0;


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

    public int getOverSpeed() {
        return overSpeed;
    }

    public void setOverSpeed(int overSpeed) {
        this.overSpeed = overSpeed;
    }


    @Override
    public String toString() {
        return " | horseName = " + horse.getNameHorse() + ", speed = " + horse.getSpeed() +
                "; riderName = " + rider.getNameRider() + ", level = " + rider.getLevel();
    }
}

