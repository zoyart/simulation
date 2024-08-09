package com.maxim;

import com.maxim.actions.Actions;
import com.maxim.entities.animals.Herbivore;
import com.maxim.map.Map;

import lombok.Getter;

@Getter
public class Simulation {
    private final Map map = new Map();
    public static int STEPS_COUNT;

    public void init() {
        Actions.initActions(this.map);
        System.out.println("Все существа созданы!");
        this.map.renderMatrix();
    }

    public void nextTurn() {
        Actions.turnActions(this.map);
        map.renderMatrix();
        Simulation.incrementStepsCount();

        // Правило окончания игры: травоядные == 0
        if (map.getEntityCountByClass(Herbivore.class) == 0) {
            System.out.println("Симуляция закончена.");
            System.exit(0);
        }
    }

    public static void incrementStepsCount() {
        Simulation.STEPS_COUNT++;
    }
}
