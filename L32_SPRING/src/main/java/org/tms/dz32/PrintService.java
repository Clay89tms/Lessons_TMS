package org.tms.dz32;

import java.util.ArrayList;
import java.util.List;

public class PrintService {
    private List<Pair> pair;

    public PrintService() {
    }

    public void announcePartners() {
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("pair# " + (i + 1) + "| horse speed = " + pair.get(i).getHorse().getSpeed() +
                    "; rider level = " + pair.get(i).getRider().getLevel() +
                    "; overall speed in this circle = " +
                    overallSpeedRandomCircle(pair.get(i).getHorse(), pair.get(i).getRider()));

        }
    }
    public int getSizePair(){
        return pair.size();
    }

    private int overallSpeedRandomCircle(Horse horse, Rider rider) {
        return ((horse.getSpeed()) * (int) (1 + (Math.random() * (rider.getLevel()))));
    }

    public List<Pair> getPair() {
        return pair;
    }

    public void setPair(List<Pair> pair) {
        this.pair = pair;
    }

}
