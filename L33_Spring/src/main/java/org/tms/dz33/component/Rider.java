package org.tms.dz33.component;

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
