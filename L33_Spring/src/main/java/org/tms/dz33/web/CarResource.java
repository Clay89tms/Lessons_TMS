package org.tms.dz33.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tms.dz33.dto.Car;
import org.tms.dz33.service.CarService;

@Controller
@RequestMapping(value = "/car")
public class CarResource {

    private CarService service;

    public CarResource(CarService service) {
        this.service = service;
    }

    @GetMapping()
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.POST)
    public String save( Car car,
//            @RequestParam(name = "number") String carNuber,
//            @RequestParam(required = false, defaultValue = "defVal") String password,
//            @RequestHeader(name = "head1", required = false) String head,
//            @CookieValue(name = "cook") String cookValue,
            @PathVariable(name = "type") String goodType

    ) {
        return "home";
    }

}
