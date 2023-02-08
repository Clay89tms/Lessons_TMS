package org.tms.dz32;

public class ControlService {

    private int money = 500;

    public ControlService() {
        System.out.println("controlService const");
    }

    private void question() {
        System.out.print("make you're choice pair (1-3): ");
    }

    public int youReChoice(int scannerChoice) {
        System.out.println("you're choice is: " + scannerChoice);
        System.out.println("bet is = 10$; you're money = " + this.money);
        return scannerChoice;
    }

    public int result(boolean result) {
        if(result){
            return 30;
        }
        return (-10);
    }


    public boolean menuMoneyControlService(int result) {
        this.money += result;
        System.out.println("you now have money: " + this.money);
        if (this.money > 9) {
            return true;
        }
        return false;
    }
}
