package org.tms.dz32;

import java.util.List;

public class PrintService {
    private List<Pair> pair;

    public PrintService() {
    }

    public void announcePartners(){
        for (int i = 0; i < pair.size(); i++) {
            System.out.println("horse speed = " + pair.get(i).getHorse() +
                        "; rider level = " + pair.get(i).getRider() +
                        "; overall speed pair# " + (i + 1));
        }

    }
}
