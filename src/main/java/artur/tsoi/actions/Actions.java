package tsoi.artur.actions;

import tsoi.artur.actions.init.InitGrassStrategy;
import tsoi.artur.actions.init.InitHerbivoreStrategy;
import tsoi.artur.actions.init.InitPredatorsStrategy;
import tsoi.artur.actions.init.InitRockStrategy;
import tsoi.artur.actions.init.InitStrategy;
import tsoi.artur.actions.turn.CreaturesMakeMoveStrategy;
import tsoi.artur.actions.turn.TurnStrategy;
import tsoi.artur.actions.turn.SpawnGrassStrategy;
import tsoi.artur.map.Map;

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
