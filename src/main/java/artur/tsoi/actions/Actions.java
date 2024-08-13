package artur.tsoi.actions;

import artur.tsoi.actions.init.InitGrassStrategy;
import artur.tsoi.actions.init.InitHerbivoreStrategy;
import artur.tsoi.actions.init.InitPredatorsStrategy;
import artur.tsoi.actions.init.InitRockStrategy;
import artur.tsoi.actions.init.InitStrategy;
import artur.tsoi.actions.turn.CreaturesMakeMoveStrategy;
import artur.tsoi.actions.turn.TurnStrategy;
import artur.tsoi.actions.turn.SpawnGrassStrategy;
import artur.tsoi.map.Map;

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
