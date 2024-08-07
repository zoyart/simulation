package com.maxim;

import com.maxim.actions.Actions;
import com.maxim.map.Map;
import lombok.Getter;

@Getter
public class Simulation {
    private final Map map;
    private int stepsCount;

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Actions.initActions(simulation.map);

        simulation.getMap().printMatrix();
    }

    public Simulation() {
        this.map = new Map();
    }

    public static void initGame() {
    }

    public void nextTurn() {

    }

    public void renderMap() {

    }
}
