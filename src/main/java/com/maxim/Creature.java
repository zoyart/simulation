package com.maxim;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;
    public abstract void makeMove();

    public Creature(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
    }
}
