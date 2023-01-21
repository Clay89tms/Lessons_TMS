package org.example.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class MyChain {
    List<Service> services = new ArrayList<>();
    public void doNext(Service service){
        int i = services.indexOf(service);
        Service service1 = services.get(i + 1);
    }
    public void add(Service service){
        services.add(service);
    }
}
