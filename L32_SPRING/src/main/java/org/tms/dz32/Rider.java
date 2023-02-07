package org.tms.dz32;

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
