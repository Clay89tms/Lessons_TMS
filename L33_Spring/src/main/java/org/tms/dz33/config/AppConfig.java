package org.tms.dz33.config;

import org.springframework.context.annotation.*;
import org.tms.dz33.component.Horse;
import org.tms.dz33.component.Pair;
import org.tms.dz33.component.Rider;
import org.tms.dz33.service.ControlService;
import org.tms.dz33.service.PrintService;


@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    @Scope("prototype")
    Horse horse(){
        return new Horse();
    }
    @Bean
    @Scope("prototype")
    Rider rider(){
        return new Rider();
    }

    @Bean
    Pair pair1(Horse horse, Rider rider){
        return new Pair(horse, rider);
    }
    @Bean
    Pair pair2(Horse horse, Rider rider){
        return new Pair(horse, rider);
    }
    @Bean
    Pair pair3(Horse horse, Rider rider){
        return new Pair(horse, rider);
    }
//    @Bean
//    PrintService printService(){
//        return printService();
//    }
//    @Bean
//    ControlService controlService(){
//        return new ControlService();
//    }

}
