package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainBetting {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");

        PrintService beanPrint = context.getBean(PrintService.class);
        ControlService beanControlService = context.getBean(ControlService.class);

        try (Scanner scanner = new Scanner(System.in)) {

            startRaice(beanPrint, beanControlService, scanner);

        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }

    }

    private static void startRaice(PrintService beanPrint, ControlService beanControlService, Scanner scanner) {
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
                System.out.println("we don't have this Pair");
            }
        } else {
            System.out.println("do not correct! please try next!");
        }
        return scanner.nextInt();
    }
}
