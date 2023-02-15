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
        boolean result = true;
        takeNewPair();

        for (int j = 1; j <= 5; j++) {
            System.out.println("Circle# " + j);

            for (Pair pair1 : pair) {
                System.out.println(pair1 + "; overal speed = " + overallSpeedRandomCircle(pair1.getHorse(), pair1.getRider(), (pair1.getNumberPair() - 1)));
            }
            waitOfCircle();
        }
        for (Pair pair1 : pair) {
            if (!(pair.get(scannerChoice - 1).getNumberPair() == pair1.getNumberPair())) {
                result = (result && (pair.get(scannerChoice - 1).getOverSpeed() > pair1.getOverSpeed()));
            }
        }
        return (result);
    }

    private int overallSpeedRandomCircle(Horse horse, Rider rider, int numberPair) {
        int randomSpeed = ((horse.getSpeed()) * (int) (1 + (Math.random() * (rider.getLevel()))));
        pair.get(numberPair).setOverSpeed(pair.get(numberPair).getOverSpeed() + randomSpeed);
        return randomSpeed;
    }

    public void waitOfCircle() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
