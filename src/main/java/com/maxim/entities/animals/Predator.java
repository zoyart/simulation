package com.maxim.entities.animals;

import com.maxim.entities.Creature;
import com.maxim.entities.EntityType;
import lombok.Getter;

@Getter
public class Predator extends Creature {
    public Predator() {
        super.setIcon("\uD83E\uDD81");
        super.setType(EntityType.PREDATOR);
        super.setHealth(20);
        super.setDamage(5);
    }

    @Override
    public void makeMove() {
        // speed можно сделать на то сколько шагов он может ходить допустим если 2 две клетки может перепрыгивать
        // if nearby the animals eat them else move somewhere
    }
}
