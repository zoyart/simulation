package com.maxim;

public class Herbivore extends Creature {
    // Травоядное
    private int y = 0;
    private int x = 0;

    public Herbivore() {
        super(12, 14);
    }

    @Override
    public void makeMove() {
        // Написать метод поиска травы
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
