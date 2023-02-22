package org.tms.dz33.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.tms.dz33.component.Pair;

import java.util.List;
import java.util.Scanner;

@Service
@RequestScope
public class PrintService {

    private final ControlServiceImpl controlService;

    public PrintService(ControlServiceImpl controlService) {
        System.out.println("PrintService const");
        this.controlService = controlService;
    }


    public void question() {
        System.out.println("You have money: " + controlService.getMoney());
        System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
    }

    public void printTablePair(List<Pair> pair) {
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("Pair# " + (i + 1) + pair.get(i));
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
        } else {
            System.out.println("do not correct! please try next!");
            scanner = new Scanner(System.in);
            question();
            return scannerChoice(sizePair, scanner);
        }
        return scannerChoice(sizePair, scanner);
    }

    public boolean startMenu(Scanner scanner) {

        question();
        int scannerChoice = scannerChoice(controlService.getPairList().size(), scanner);
        controlService.takeNewPair();

        System.out.println();
        printTablePair(controlService.getPairList());
        boolean result = controlService.startCircle(scannerChoice);

        return controlService.resultMoney(result);
    }

    public void waitOfCircle() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}