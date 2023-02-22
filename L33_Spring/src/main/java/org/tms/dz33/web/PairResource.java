package org.tms.dz33.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.tms.dz33.component.Horse;
import org.tms.dz33.component.Pair;
import org.tms.dz33.component.Rider;
import org.tms.dz33.service.ControlService;
import org.tms.dz33.service.PrintService;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping(value = "/circle")
public class PairResource {

    private final ControlService controlService;

    private PrintService printService;
    private Pair pair;

    public PairResource(ControlService controlService, Pair pair, PrintService printService) {
        System.out.println("pairRes const");
        this.printService = printService;
        this.controlService = controlService;

        this.pair = pair;
    }


    @GetMapping("/menu")
    public ModelAndView homePage() {
        List<Pair> list = new ArrayList<>();
        
        Horse horse = new Horse();
        horse.setNameHorse("oneH1");

        Rider rider = new Rider();
        rider.setNameRider("oneR1");
        list.add(new Pair(horse, rider));
        
        Horse horse1 = new Horse();
        horse.setNameHorse("oneH2");

        Rider rider1 = new Rider();
        rider.setNameRider("oneR2");
        list.add(new Pair(horse1, rider1));
        
        Map<String, Pair> map1 = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map1.put(list.get(i).getRider().getNameRider(), list.get(i));
        }
        return new ModelAndView("race", map1);

//        return "startMenu";
    }

    @GetMapping("/getRace")
    public ModelAndView savePair(Horse horse, Rider rider) {
        List<Pair> pairList = controlService.getPairList();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < pairList.size(); i++) {
            String number = "pairs" + map.get(i);
            map.put(number, pairList.get(i));
        }
        return new ModelAndView("race", map);
    }

    @PostMapping("/add")
    public ModelAndView addPair(@Valid Horse horse, BindingResult result1,
                                @Valid Rider rider, BindingResult result2) {
        ModelAndView modelAndView = new ModelAndView("startMenu");
        if (result1.hasErrors() || result2.hasErrors()) {
            HashMap<String, String> errors = new HashMap<>();
            FieldError fieldError;
            if (result1.hasErrors()) {
                fieldError = result1.getFieldError();
                errors.put("err_" + fieldError.getField(), fieldError.getDefaultMessage());
            }
            if (result2.hasErrors()) {
                fieldError = result2.getFieldError();
                errors.put("err_" + fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.addAllObjects(errors);

            return modelAndView;
        }
        Map<String, String> model = new HashMap<>();
        model.put("pair1", "horRid");
        pair = new Pair(horse, rider);
        pair.createPartner();
        controlService.addPairInToList(pair);
        List<Pair> pairList = controlService.getPairList();
        return new ModelAndView("startMenu", model);
    }

}
