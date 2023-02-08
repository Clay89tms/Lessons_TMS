package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainBetting {
    public static void main(String[] args) {
//        PrintService printService = new PrintService();
//        Horse horse1 = new Horse();
//        horse1.takeHorse();
//        Horse horse2 = new Horse();
//        horse2.takeHorse();
//        Horse horse3 = new Horse();
//        horse3.takeHorse();
//        Rider rider1 = new Rider();
//        rider1.takeRider();
//        Rider rider2 = new Rider();
//        rider2.takeRider();
//        Rider rider3 = new Rider();
//        rider3.takeRider();
//        Pair pair1 = new Pair(horse1, rider1);
//        Pair pair2 = new Pair(horse2, rider2);
//        Pair pair3 = new Pair(horse3, rider3);
//        System.out.println(PrintService.getPair());


        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");

        PrintService beanPrint = context.getBean(PrintService.class);

        ControlService beenControl = context.getBean(ControlService.class);
        beenControl.youReChoice(scannerChoice(beanPrint.getSizePair()));


        beanPrint.announcePartners();
    }

    private static int scannerChoice(int sizePair) {
        int scannerNext = 0;
        try (Scanner scanner = new Scanner(System.in)) {

            if (scanner.hasNextInt()) {
                    scannerNext = scanner.nextInt();
                if (scannerNext <= sizePair) {

                return scannerNext;
                }
            } else {
                System.out.println("do not correct! please try next!");
                return scannerChoice(sizePair);
            }
        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }
        return scannerNext;
    }
}
