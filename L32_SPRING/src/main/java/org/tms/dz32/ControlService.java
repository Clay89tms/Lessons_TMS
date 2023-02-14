package org.tms.dz32;

import java.util.List;

public class ControlService {

    private static int money = 50;
    private List<Pair> pair;

    public ControlService() {
        System.out.println("controlService const");
    }

    private void takeNewPair() {
        for (int i = 0; i < pair.size(); i++) {
            pair.get(i).createPartner();
        }
    }

    public boolean startCircle(int scannerChoice) {
        int over1 = 0;
        int over2 = 0;
        int over3 = 0;
        takeNewPair();

        System.out.println("na4");
        for (Pair perem : pair) {

            System.out.println("Pair# " + perem);
        }
        System.out.println("kon");

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
            waitOfCircle();
        }
        System.out.println("Overall1 = " + over1 + "\nOverall2 = " + over2 + "\nOverall3 = " + over3);
        int bestResult;
        if (over1 > Math.max(over2, over3)) {
            bestResult = 1;
        } else if (over2 > Math.max(over1, over3)) {
            bestResult = 2;
        } else {
            bestResult = 3;
        }
        return (scannerChoice == bestResult);
    }

    public void waitOfCircle() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int overallSpeedRandomCircle(Horse horse, Rider rider) {
        return ((horse.getSpeed()) * (int) (1 + (Math.random() * (rider.getLevel()))));
    }

    public boolean menuControlService(boolean result) {
        if (result) {
            System.out.println("you win! Congratulations!!!");
            money += 30;
        } else {
            System.out.println("you louse... don't worry!");
            money -= 10;
        }
        return (money > 9);
    }

    public List<Pair> getPair() {
        return pair;
    }

    public void setPair(List<Pair> pair) {
        this.pair = pair;
    }

    public static int getMoney() {
        return money;
    }
}
