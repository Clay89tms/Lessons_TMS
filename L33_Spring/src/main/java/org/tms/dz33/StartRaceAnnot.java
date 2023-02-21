package org.tms.dz33;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.tms.dz33.service.ControlService;
import org.tms.dz33.service.PrintService;

import java.util.Scanner;

public class StartRaceAnnot {
    public void start(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.tms.dz33");
        PrintService beanPrintService = context.getBean(PrintService.class);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to bet of sports!\n");
            startRace(beanPrintService, scanner);
        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }
    }

    private void startRace(PrintService beanControlService, Scanner scanner) {
        if (beanControlService.menuControlService(scanner)) {
            startRace(beanControlService, scanner);
        }
    }
}
