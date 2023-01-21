package org.example.memento;

public class MainMomento {
    public static void main(String[] args) {
        PlayerMomento player = new PlayerMomento("Clay", 100, 55, 50);
        player.save();
        System.out.println(player);

        player.setHeals(10);
        player.setStrange(70);
        player.setShield(0);
        System.out.println(player);

        player.load();
        System.out.println(player);
    }
}
