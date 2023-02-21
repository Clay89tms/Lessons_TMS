package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class StartRaceXML {
    public void start(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");
        ControlService beanControlService = context.getBean(ControlService.class);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to bet of sports!\n");
            startRace(beanControlService, scanner);
        } catch (Exception exception) {
            System.out.println("exep" + exception);
        }
    }

    private void startRace(ControlService beanControlService, Scanner scanner) {
        if (beanControlService.menuControlService(scanner)) {
            startRace(beanControlService, scanner);
        }
    }
}
