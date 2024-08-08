package com.maxim;

import com.maxim.actions.Actions;
import com.maxim.map.Map;

import lombok.Getter;

@Getter
public class Simulation {
    private final Map map = new Map();
    private static int STEPS_COUNT;

    public void init() {
        Actions.initActions(this.map);
        System.out.println("Все существа созданы!");
        this.map.renderMatrix();
    }

    public void nextTurn() {
        Actions.turnActions(this.map);
        map.renderMatrix();
        Simulation.incrementStepsCount();
        System.out.println("Это был шаг №" + Simulation.STEPS_COUNT);
    }

    public static void incrementStepsCount() {
        Simulation.STEPS_COUNT++;
    }
}
