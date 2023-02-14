package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static org.tms.dz32.ScannerChoice.scannerChoice;

public class StartRace {
    public static void start(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");
        ControlService beanControlService = context.getBean(ControlService.class);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to bet of sports!");
            startRace(beanControlService, scanner);
        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }
    }

    private static void startRace(ControlService beanControlService, Scanner scanner) {
        PrintService.question();
        if (beanControlService.menuControlService(
                beanControlService.startCircle(scannerChoice(beanControlService.getPair().size(), scanner)))) {
            startRace(beanControlService, scanner);
        }
    }
}
