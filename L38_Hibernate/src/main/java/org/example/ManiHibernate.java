package org.example;

import org.example.domain.Address;
import org.example.domain.Phone;
import org.example.domain.UserEntity;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;
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
        UserEntity userEntity = userService.get(1);

        System.out.println("---------main!------------");
        System.out.println(userEntity);

//        List<Phone> phones = userEntity.getPhones();

        System.out.println("");
    }

    public UserEntity create() {
        UserEntity user = new UserEntity();
        user.setLogin("login" + new Random().nextInt());
        user.setPassword("password1");
        Address address = new Address("Minsk", "Lenina");
        user.setAddress(address);
        user.setBirthday(new Date());
//        System.out.println("create user = " + user);

        Phone phone1 = new Phone();
        phone1.setNumber((new Random().nextInt()));

        Phone phone2 = new Phone();
        phone2.setNumber((new Random().nextInt()));

        user.setPhones(List.of(phone1, phone2));

        return user;
    }
}