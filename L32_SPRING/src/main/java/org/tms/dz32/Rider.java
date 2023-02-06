package org.tms.dz32;

public class Rider {

    private int level;

    public Rider() {
    }

    public int takeRider() {
        return this.level = (int) (1 + Math.random() * 10);
//        System.out.println("Level Rider: " + level);
    }

    public int getLevel() {
        return level;
    }
}
