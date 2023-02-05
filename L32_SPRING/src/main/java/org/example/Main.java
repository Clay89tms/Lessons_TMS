package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        Messenger bean = context.getBean(Messenger.class);
//        bean.sendMessage("gmail.com");

//        Map<String, Messenger> beansOfType = context.getBeansOfType(Messenger.class);
//        beansOfType.forEach((s, messanger) -> messanger.sendMessage("mess"));
        UserHandler bean = context.getBean(UserHandler.class);
        bean.saveUser();

        UserHandlerImpl bean1 = context.getBean(UserHandlerImpl.class);
        bean1.saveUser();

        context.close();

    }
}