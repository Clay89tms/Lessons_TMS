package org.tms.dz33.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Rider {

    private int level;

    public Rider() {
        System.out.println("rider const");
    }

    public void takeRider() {
        this.level = (int) (1 + Math.random() * 10);
//        System.out.println("Level Rider: " + level);
    }

    public int getLevel() {
        return level;
    }
}
