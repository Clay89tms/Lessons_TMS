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

    public boolean startCircle(int scannerChoice) {
        int over1 = 0;
        int over2 = 0;
        int over3 = 0;
        for (int j = 1; j <= 5; j++) {


            System.out.println("Circle# " + j);
            for (int i = 0; i < pair.size(); i++) {
                int over;
                System.out.print("pair# " + (i + 1) + "| horse speed = " + pair.get(i).getHorse().getSpeed() +
                        "; rider level = " + pair.get(i).getRider().getLevel() +
                        "; overall speed in this circle = ");
                switch (i) {
                    case 0:
                        over = overallSpeedRandomCircle(pair.get(i).getHorse(), pair.get(i).getRider());
                        over1 += over;
                        System.out.println(over);
                        break;
                    case 1:
                        over = overallSpeedRandomCircle(pair.get(i).getHorse(), pair.get(i).getRider());
                        over2 += over;
                        System.out.println(over);
                        break;
                    case 2:
                        over = overallSpeedRandomCircle(pair.get(i).getHorse(), pair.get(i).getRider());
                        over3 += over;
                        System.out.println(over);
                        break;
                }
            }
        }
        System.out.println("Overal1 = " + over1 + "\nOveral2 = " + over2 + "\nOveral3 = " + over3);
        int bestResult;
        if(over1 > Math.max(over2, over3)){
            bestResult = 1;
        } else if (over2 > Math.max(over1, over3)) {
            bestResult = 2;
        } else {
            bestResult = 3;
        }
        return (scannerChoice == bestResult);
    }

    public int getSizePair() {
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
