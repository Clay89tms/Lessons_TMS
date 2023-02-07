package org.tms.dz32;

import java.util.List;

public class PrintService {
    private Pair pair;
    private int i = 1;


    public PrintService(Pair pair) {
        this.pair = pair;
    }


    public void announcePartners() {
        System.out.println("horse speed = " + pair.getHorse().getSpeed() +
                "; rider level = " + pair.getRider().getLevel() +
                "; overall speed pair# " + i++);
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }
}
