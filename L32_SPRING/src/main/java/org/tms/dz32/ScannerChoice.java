package org.tms.dz32;

import java.util.Scanner;

public class ScannerChoice {

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
