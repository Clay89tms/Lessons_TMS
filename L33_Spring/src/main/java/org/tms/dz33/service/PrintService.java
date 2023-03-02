package org.tms.dz33.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.tms.dz33.component.Pair;

import java.util.List;
import java.util.Map;

@Service
@RequestScope
public class PrintService {

    private final ControlService controlService;

    public PrintService(ControlService controlService) {
        System.out.println("PrintService const");
        this.controlService = controlService;
    }

    public void printTablePair(List<Pair> pair) {
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("Pair# " + (i + 1) + pair.get(i));
        }
        System.out.println("________________________________");
    }

    public Map<String, Object> startMenu(int choose, int bet, Map<String, Object> model) {
        controlService.takeNewPair();
        printTablePair(controlService.getPairList());

        int winnerPair = controlService.startCircle(choose);
        String endOfRaceMessage = controlService.resultMoney(choose, bet, winnerPair);

        model.put("endOfRaceMessage", endOfRaceMessage);
        model.put("winnerPair", winnerPair);
        return model;
    }

}