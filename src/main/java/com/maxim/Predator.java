package com.maxim;

import java.util.Random;

public class Predator extends Creature {
    // Хищник
    private int y = 0;
    private int x = 0;
    public Predator() {
        super(15, 15);
    }

    @Override
    public void makeMove() {
        // speed можно сделать на то сколько шагов он может ходить допустим если 2 две клетки может перепрыгивать
        // if nearby the animals eat them else move somewhere
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
