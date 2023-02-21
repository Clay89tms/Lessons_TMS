package org.example.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMomento {

    private String name;
    private int heals;
    private int strange;
    private int shield;

    private PlayerMomento player;

    public PlayerMomento(String name, int heals, int strange, int shield) {
        this.name = name;
        this.heals = heals;
        this.strange = strange;
        this.shield = shield;
    }

    public void save(){
        player = new PlayerMomento();
        player.setName(name);
        player.setHeals(heals);
        player.setStrange(strange);
        player.setShield(shield);
    }

    public PlayerMomento load(){
        name = player.getName();
        heals = player.getHeals();
        strange = player.getStrange();
        shield = player.getShield();
        return this;
    }

    @Override
    public String toString() {
        return "PlayerMomento{" +
                "name='" + name + '\'' +
                ", heals=" + heals +
                ", strange=" + strange +
                ", shield=" + shield +
                '}';
    }
}
