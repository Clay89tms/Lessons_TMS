package org.tms.dz33.service;

import org.springframework.stereotype.Service;
import org.tms.dz33.aop.MyBenchmark;
import org.tms.dz33.component.Pair;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Service
public class ControlService {

    private static int money = 100;

    private PrintService printService;

    @NotBlank(message = "you don't choose")
    private String choose;

    @Min(value = 10)
    @Max(value = 30)
    @NotBlank
    private String bet;

    private List<Pair> pairList = new ArrayList<>();


    public ControlService() {
        System.out.println("Control const");

    }

    public void takeNewPair() {
        for (int i = 0; i < pairList.size(); i++) {
            pairList.get(i).createPartner();
        }
    }

    @MyBenchmark
    public int startCircle(int choose) {
        --choose;
        int winner = choose;
        for (int j = 1; j <= 5; j++) {
            System.out.println("Circle# " + j);

            for (int i = 0; i < pairList.size(); i++) {
                System.out.println("Pair# " + (i + 1) + "; overal speed = " + overallSpeedRandomCircle((pairList.get(i))));
            }
        }
        System.out.println("Finish:");
        for (int i = 0; i < pairList.size(); i++) {
            System.out.println("Pair # " + (i + 1) + ", overall speed = " + this.pairList.get(i).getOverSpeed());
            if (i != choose) {
                if (this.pairList.get(winner).getOverSpeed() < this.pairList.get(i).getOverSpeed()) {
                    winner = i;
                }
            }
            System.out.println("winner is : " + this.pairList.get(winner).getRider().getNameRider());
        }

        return (winner + 1);
    }

    public String resultMoney(int choose, int bet, int winnerPair) {
        String endOfRaceMessage = "your choose = " + choose + "; your bet = " + bet + " | number winner Pair = " + winnerPair;
        if (choose == winnerPair) {
            endOfRaceMessage += " | you win! Congratulations!!!";
            money += (bet * 3);
        } else {
            endOfRaceMessage += " | you louse... don't worry!";
            money -= bet;
        }
        return endOfRaceMessage;
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

    public void addPairInToList(Pair pair) {
        pairList.add(pair);
    }

    public int getMoney() {
        return money;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }
}
