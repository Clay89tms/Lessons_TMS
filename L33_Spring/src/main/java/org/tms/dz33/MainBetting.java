package org.tms.dz33;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainBetting {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");

        PrintService beanPrint = context.getBean(PrintService.class);
        ControlService beanControlService = context.getBean(ControlService.class);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to bet of sports!");
            startRaice(beanPrint, beanControlService, scanner);

        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }

    }

    private static void startRaice(PrintService beanPrint, ControlService beanControlService, Scanner scanner) {
        beanControlService.question();
        if (beanControlService.menuMoneyControlService(beanControlService
                .result(beanPrint.startCircle(scannerChoice(beanPrint.getSizePair(), scanner))))) {
            startRaice(beanPrint, beanControlService, scanner);
        }
    }

    private static int scannerChoice(int sizePair, Scanner scanner) {

        if (scanner.hasNextInt()) {
            int scannerNext = scanner.nextInt();

            if (scannerNext <= sizePair) {
                return scannerNext;
            } else {
                System.out.println("\n\tWe DON'T have this Pair");
                System.out.print("bet is = 10$; \nmake you're choice pair (1-3): ");
            }
        }
        else{
            System.out.println("do not correct! please try next!");
            scanner = new Scanner(System.in);
            System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
            return scannerChoice(sizePair, scanner);
        }
        return scannerChoice(sizePair, scanner);
    }
}
