package org.tms.dz32;

import java.util.List;
import java.util.Scanner;

public class PrintService {

    public PrintService() {
    }

    public static void question() {
        System.out.println("You have money: " + ControlService.getMoney());
        System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
    }

    public static void printTablePair(List<Pair> pair){
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("Pair# " + (i+1) + pair.get(i));
        }
        System.out.println("________________________________");
    }

    public static int scannerChoice(int sizePair, Scanner scanner) {

        if (scanner.hasNextInt()) {
            int scannerNext = scanner.nextInt();

            if (scannerNext <= sizePair) {
                return scannerNext;
            } else {
                System.out.println("\n\tWe DON'T have this Pair");
                PrintService.question();
            }
        }
        else{
            System.out.println("do not correct! please try next!");
            scanner = new Scanner(System.in);
            PrintService.question();
            return scannerChoice(sizePair, scanner);
        }
        return scannerChoice(sizePair, scanner);
    }

}