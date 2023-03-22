package com.example.springbootmvctms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@Controller
@RequestMapping("/")
public class SpringBootMvcTmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcTmsApplication.class, args);
    }
    @GetMapping
    public String getHome(){
        return "home2.jsp";
    }


}
