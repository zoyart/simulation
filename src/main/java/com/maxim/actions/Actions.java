package com.maxim.actions;

import com.maxim.actions.init.InitGrass;
import com.maxim.actions.init.InitHerbivore;
import com.maxim.actions.init.InitPredators;
import com.maxim.actions.init.InitRock;
import com.maxim.actions.init.InitStrategy;
import com.maxim.actions.init.InitTree;
import com.maxim.entities.Creature;
import com.maxim.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Actions {
    public static void initActions(Map map) {
        List<InitStrategy> initActions = new ArrayList<>(List.of(
                new InitPredators(),
                new InitHerbivore(),
                new InitGrass(),
                new InitTree(),
                new InitRock()
        ));

        // Выполнение всех стратегий инициализации
        for (InitStrategy action : initActions) {
            action.init(map);
        }
    }

    public static void turnActions(Map map) {
        List<Creature> creatures = new ArrayList<>();

        for (Creature creature : creatures) {
            creature.makeMove();
        }
    }
}
