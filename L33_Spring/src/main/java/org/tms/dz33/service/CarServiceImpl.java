package org.tms.dz33.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.tms.dz33.dto.Car;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public void save(Car car) {
        System.out.println("car was saved " + car);

    }
}
