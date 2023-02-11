package org.tms.dz33;

public class ControlService {

    private int money = 500;

    public ControlService() {
        System.out.println("controlService const");
    }

    public void question() {
        System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
    }

    public int result(boolean result) {
        if(result){
            System.out.println("you win! Congratulations!!!");
            return 30;
        }
        System.out.println("you louse... don't worry!");
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
