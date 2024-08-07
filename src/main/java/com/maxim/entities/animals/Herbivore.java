package com.maxim.entities.animals;

import com.maxim.entities.Creature;
import com.maxim.entities.EntityType;

public class Herbivore extends Creature {
    public Herbivore() {
        super.setIcon("\uD83D\uDC11");
        super.setType(EntityType.HERBIVORE);
    }

    @Override
    public void makeMove() {
        // Написать метод поиска травы
    }
}
