package org.example.factory_method;

import lombok.ToString;

public class RepairService {
    public void repair(Factory factory) {
        Object o = factory.create();
    }
}
