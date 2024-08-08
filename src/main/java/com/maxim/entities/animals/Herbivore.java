package com.maxim.entities.animals;

import com.maxim.entities.Creature;
import com.maxim.entities.EntityType;

public class Herbivore extends Creature {
    public Herbivore() {
        super.setIcon("\uD83D\uDC11");
        super.setType(EntityType.HERBIVORE);
        super.setHealth(10);
        super.setDamage(1);
    }

    @Override
    public void makeMove() {
        // Написать метод поиска травы
    }
}
