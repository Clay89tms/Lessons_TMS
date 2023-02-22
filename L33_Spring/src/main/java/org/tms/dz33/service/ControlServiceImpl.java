package org.tms.dz33.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.tms.dz33.aop.MyBenchmark;
import org.tms.dz33.component.Pair;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControlServiceImpl {

    private static int money = 50;

    private final PrintService printService;

    private List<Pair> pairList = new ArrayList<>();

    public ControlServiceImpl(PrintService printService) {
        System.out.println("Control const");
        this.printService = printService;
    }


    public void takeNewPair() {
        for (int i = 0; i < pairList.size(); i++) {
            pairList.get(i).createPartner();
        }
    }

    @MyBenchmark
    public boolean startCircle(int scannerChoice) {
        boolean result = true;

        for (int j = 1; j <= 5; j++) {
            System.out.println("Circle# " + j);

            for (int i = 0; i < pairList.size(); i++) {
                System.out.println("Pair# " + (i + 1) + "; overal speed = " + overallSpeedRandomCircle((pairList.get(i))));
            }
            printService.waitOfCircle();
        }
        for (Pair pair : pairList) {
            if (!(this.pairList.get(scannerChoice - 1).getOverSpeed() == pair.getOverSpeed())) {
                result = (result && (this.pairList.get(scannerChoice - 1).getOverSpeed() > pair.getOverSpeed()));
            }
        }
        return (result);
    }

    public boolean resultMoney(boolean result) {
        if (result) {
            System.out.println("you win! Congratulations!!!");
            money += 30;
        } else {
            System.out.println("you louse... don't worry!");
            money -= 10;
        }
        return (money > 9);
    }


    public int overallSpeedRandomCircle(Pair pair) {
        int randomSpeed = ((pair.getHorse().getSpeed()) * (int) (1 + (Math.random() * (pair.getRider().getLevel()))));
        pair.setOverSpeed(pair.getOverSpeed() + randomSpeed);
        return randomSpeed;
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    public void setPairList(List<Pair> pairList) {
        this.pairList = pairList;
    }
    public void addPairInToList(Pair pair){
        pairList.add(pair);
    }

    public int getMoney() {
        return money;
    }
}
