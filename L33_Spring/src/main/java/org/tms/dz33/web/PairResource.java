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
        Map<String, List<Pair>> model = new HashMap<>();

        List<Pair> list = controlService.getPairList();
        model.put("pairList", list);
        return new ModelAndView("startMenu", model);

//        return "startMenu";
    }

    @GetMapping("/toStart")
    public ModelAndView savePair() {
        Map<String, List<Pair>> model = new HashMap<>();

        List<Pair> list = controlService.getPairList();
        model.put("pairList", list);
        return new ModelAndView("race", model);
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
        Map<String, Object> model = new HashMap<>();

        pair = new Pair(horse, rider);
        pair.createPartner();
        controlService.addPairInToList(pair);
        List<Pair> list = controlService.getPairList();
        model.put("pairList", list);
        int money = controlService.getMoney();
//        model.put("")
        return new ModelAndView("startMenu", model);
    }

}
