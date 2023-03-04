package org.example;

import org.example.domain.Address;
import org.example.domain.Phone;
import org.example.domain.UserEntity;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Random;

public class ManiHibernate {
    public static void main(String[] args) {
        ManiHibernate main = new ManiHibernate();

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        UserService userService = context.getBean(UserService.class);

        userService.save(main.create());
        userService.save(main.create());
        userService.save(main.create());

        System.out.println("___________________________");

        UserEntity userEntity = userService.get(2);

        Phone phone = userService.getPhone(2);
        System.out.println(userEntity);
    }

    public UserEntity create() {
        UserEntity user = new UserEntity();
        user.setLogin("login" + new Random().nextInt());
        user.setPassword("password1");
        Address address = new Address("Minsk", "Lenina");
        user.setAddress(address);
        user.setBirthday(new Date());
        System.out.println("create user = " + user);

        Phone phone = new Phone();
        phone.setNumber((new Random().nextInt()));
        user.setPhone(phone);

        return user;
    }
}