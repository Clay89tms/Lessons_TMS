package org.tms.dz32;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBetting {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-betting.xml");

        Pair bean = context.getBean(Pair.class);
        context.getBean(Pair.class).take();
    }
}
