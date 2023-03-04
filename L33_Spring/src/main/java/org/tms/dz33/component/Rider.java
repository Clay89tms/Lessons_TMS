package org.tms.dz33.component;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class Rider {

    private int level;

    @NotBlank(message = "must not be blank")
    private String nameRider;

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

    public String getNameRider() {
        return nameRider;
    }

    public void setNameRider(String nameRider) {
        this.nameRider = nameRider;
    }
}
