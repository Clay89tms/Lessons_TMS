package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
        beanPrint.announcePartners();
//        Pair bean = context.getBean(Pair.class);
//        bean.createPartner();
//        PrintService bean1 = context.getBean(PrintService.class);
//        bean1.announcePartners();
    }
}
