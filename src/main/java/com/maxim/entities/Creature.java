package com.maxim.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature extends Entity {
    private int health;
    private int damage;
    public abstract void makeMove();
}
