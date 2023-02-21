package org.tms.dz33.service;

import org.springframework.stereotype.Service;
import org.tms.dz33.aop.MyBenchmark;
import org.tms.dz33.component.Pair;

import java.util.List;

public interface ControlService {

        void takeNewPair();

        boolean startCircle(int scannerChoice);

        boolean resultMoney(boolean result);

        int overallSpeedRandomCircle(Pair pair);

        void addPairInToList(Pair pair);
        List<Pair> getPairList();
}
