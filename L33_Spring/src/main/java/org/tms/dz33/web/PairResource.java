package org.tms.dz33.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tms.dz33.component.Horse;
import org.tms.dz33.component.Pair;
import org.tms.dz33.component.Rider;
import org.tms.dz33.service.ControlService;
import org.tms.dz33.service.PrintService;

import javax.validation.Valid;
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
        Map<String, Object> model = new HashMap<>();

        if (!controlService.getPairList().isEmpty()) {
            startIfoPairAndMoney(model);
        } else {
            model.put("money", controlService.getMoney());
        }
        return new ModelAndView("startMenu", model);
    }

    @PostMapping("/toStart")
    public ModelAndView savePair(@Valid ControlService betChoose, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("startMenu");

        Map<String, Object> model = new HashMap<>();
        List<Pair> list = controlService.getPairList();
        model.put("pairList", list);


        if (result.hasErrors()) {
            HashMap<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError1 : fieldErrors) {
                errors.put("err_" + fieldError1.getField(), fieldError1.getDefaultMessage());
            }

            modelAndView.addAllObjects(errors);
        } else {
            System.out.println();


            Integer bet = Integer.valueOf(betChoose.getBet());
            Integer choose = Integer.valueOf(betChoose.getChoose());
            printService.startMenu(choose, bet, model);

            model.put("isThereAWinner", true);
//            modelAndView.addAllObjects(model);
        }
        startIfoPairAndMoney(model);
        modelAndView.addAllObjects(model);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addPair(@Valid Horse horse, BindingResult result1,
                                @Valid Rider rider, BindingResult result2) {

        ModelAndView modelAndView = new ModelAndView("startMenu");

        Map<String, Object> model = new HashMap<>();


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
            startIfoPairAndMoney(model);
            modelAndView.addAllObjects(model);

            return modelAndView;
        }

        pair = new Pair(horse, rider);
        pair.createPartner();
        controlService.addPairInToList(pair);
        startIfoPairAndMoney(model);
        modelAndView.addAllObjects(model);
        return modelAndView;
    }

    public Map<String, Object> startIfoPairAndMoney(Map<String, Object> model) {
        model.put("pairList", controlService.getPairList());
        model.put("money", controlService.getMoney());
        return model;
    }


}
