package org.tms.dz32;

import java.util.Scanner;

public class ControlService {

    private static int money = 500;

    public ControlService() {
        System.out.println("controlService const");
    }

private void question(){
    System.out.print("make you're choice pair (1-3): ");
}

    public void choice(int scannerChoice) {
        System.out.println("you're choice is: " + scannerChoice);

    }

}
