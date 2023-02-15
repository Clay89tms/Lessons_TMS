package org.tms.dz33.service;

import org.tms.dz33.component.Pair;

import java.util.List;
import java.util.Scanner;


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

        for (int j = 1; j <= 5; j++) {
            System.out.println("Circle# " + j);

            for (int i = 0; i < pair.size(); i++) {
                System.out.println("Pair# " + (i + 1) + "; overal speed = " + overallSpeedRandomCircle((pair.get(i))));
            }
            waitOfCircle();
        }
        for (Pair pair : pair) {
            if (!(this.pair.get(scannerChoice - 1).getOverSpeed() == pair.getOverSpeed())) {
                result = (result && (this.pair.get(scannerChoice - 1).getOverSpeed() > pair.getOverSpeed()));
            }
        }
        return (result);
    }

    private int overallSpeedRandomCircle(Pair pair) {
        int randomSpeed = ((pair.getHorse().getSpeed()) * (int) (1 + (Math.random() * (pair.getRider().getLevel()))));
        pair.setOverSpeed(pair.getOverSpeed() + randomSpeed);
        return randomSpeed;
    }

    public void waitOfCircle() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean menuControlService(Scanner scanner) {
        PrintService.question();
        int scannerChoice = PrintService.scannerChoice(pair.size(), scanner);
        takeNewPair();

        System.out.println();
        PrintService.printTablePair(getPair());
        boolean result = startCircle(scannerChoice);

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
