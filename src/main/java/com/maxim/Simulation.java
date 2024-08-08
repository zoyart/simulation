package com.maxim;

import com.maxim.actions.Actions;
import com.maxim.map.Map;
import com.maxim.util.Input;
import lombok.Getter;

@Getter
public class Simulation {
    private final Map map;
    private int stepsCount;

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Map map = simulation.getMap();
        map.renderMatrix();
        // Инициализация всех объектов на карте.
        Actions.initActions(map);

        // Выполнение шага по вводу пользователя
        String userInput;
        do {
            // Выолнение всех действий за ход
            Actions.turnActions(map);
            simulation.incrementStepsCount();
            userInput = Input.userInput("input: ");
        } while (!userInput.equals("s"));
    }

    public Simulation() {
        this.map = new Map();
    }

    public void incrementStepsCount() {
        this.stepsCount++;
    }
}
