package org.tms.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.tms.boot.service.BookService;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootTmsApplication implements CommandLineRunner {

//    @Autowired
//    private BookService service;

//    @Bean
//    DataSource dataSource(){
//        return new DriverManagerDataSource();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTmsApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");
    }
}
