package org.tms.dz33.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.dz33.component.Pair;

import java.util.List;
import java.util.Scanner;

@Service
public class PrintService {

    @Autowired
    ControlService controlService;

    public PrintService() {
    }


    public void question() {
        System.out.println("You have money: " + ControlService.getMoney());
        System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
    }

    public void printTablePair(List<Pair> pair){
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("Pair# " + (i+1) + pair.get(i));
        }
        System.out.println("________________________________");
    }

    public int scannerChoice(int sizePair, Scanner scanner) {

        if (scanner.hasNextInt()) {
            int scannerNext = scanner.nextInt();

            if (scannerNext <= sizePair) {
                return scannerNext;
            } else {
                System.out.println("\n\tWe DON'T have this Pair");
                question();
            }
        }
        else{
            System.out.println("do not correct! please try next!");
            scanner = new Scanner(System.in);
            question();
            return scannerChoice(sizePair, scanner);
        }
        return scannerChoice(sizePair, scanner);
    }
    public boolean menuControlService(Scanner scanner) {

        question();
        int scannerChoice = scannerChoice(controlService.getPair().size(), scanner);
        controlService.takeNewPair();

        System.out.println();
        printTablePair(controlService.getPair());
        boolean result = controlService.startCircle(scannerChoice);

        return controlService.resultMoney(result);
    }

}