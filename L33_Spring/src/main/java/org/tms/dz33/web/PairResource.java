package org.tms.dz33.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tms.dz33.component.Horse;
import org.tms.dz33.component.Pair;
import org.tms.dz33.component.Rider;
import org.tms.dz33.service.ControlService;
import org.tms.dz33.service.ControlServiceImpl;
import org.tms.dz33.service.PrintService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/circle")
public class PairResource {

    private ControlService controlService;

//    private PrintService printService;
    private Pair pair;

    public PairResource(ControlServiceImpl controlService, Pair pair) {
        this.controlService = controlService;

        this.pair = pair;
    }

    public PairResource() {
        System.out.println("pairRes const");
    }

    @GetMapping()
    public String homePage() {
//        controlService.getPairList();
        return "startMenu";
    }

    @PostMapping("/new")
    public String savePair(Horse horse, Rider rider) {
//        controlService.takeNewPair();
        return "startMenu";
    }

    @PostMapping()
    public ModelAndView addPair(Horse horse, Rider rider) {

        Map<String, String> model = new HashMap<>();
        model.put("pair1", "horRid");
        pair = new Pair(horse, rider);
        pair.createPartner();
        controlService.addPairInToList(pair);
        List<Pair> pairList = controlService.getPairList();
        return new ModelAndView("startMenu", model);
    }


}
