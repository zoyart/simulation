package com.maxim.actions;

import com.maxim.actions.init.InitGrassStrategy;
import com.maxim.actions.init.InitHerbivoreStrategy;
import com.maxim.actions.init.InitPredatorsStrategy;
import com.maxim.actions.init.InitRockStrategy;
import com.maxim.actions.init.InitStrategy;
import com.maxim.actions.init.InitTreeStrategy;
import com.maxim.actions.turn.CreaturesMakeMoveStrategy;
import com.maxim.actions.turn.TurnStrategy;
import com.maxim.actions.turn.SpawnGrassStrategy;
import com.maxim.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Actions {
    public static void initActions(Map map) {
        List<InitStrategy> initActions = new ArrayList<>(List.of(
                new InitPredatorsStrategy(),
                new InitHerbivoreStrategy(),
                new InitGrassStrategy(),
//                new InitTreeStrategy(),
                new InitRockStrategy()
        ));

        // Выполнение всех стратегий инициализации
        for (InitStrategy action : initActions) {
            action.init(map);
        }
    }

    public static void turnActions(Map map) {
        List<TurnStrategy> turnActions = new ArrayList<>(List.of(
                new SpawnGrassStrategy(),
                new CreaturesMakeMoveStrategy()
        ));

        // Выполнение всех стратегий хода
        for (TurnStrategy action : turnActions) {
            action.turn(map);
        }
    }
}
