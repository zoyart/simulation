package tsoi.artur.actions.turn;

import tsoi.artur.entities.Creature;
import tsoi.artur.entities.animals.Herbivore;
import tsoi.artur.entities.animals.Predator;
import tsoi.artur.map.Map;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class CreaturesMakeMoveStrategy implements TurnStrategy {
    @Override
    public void turn(Map map) {
        List<Predator> predators = map.getAllEntityByClass(Predator.class);
        List<Herbivore> herbivore = map.getAllEntityByClass(Herbivore.class);

        /*
        Делаем так, чтобы первыми ходили хищники, иначе может зациклится.
        Это происходит тогда, когда овца первая ходит и идёт к кусту,
        хищник загораживает путь, овца ищет обход и отходит на 1 клетку, волк идёт за ней и так до бесконечности
         */
        List<Creature> creatures = new LinkedList<>();
        creatures.addAll(predators);
        creatures.addAll(herbivore);

        // Тут описать ходы животных на карте
        for (Creature creature : creatures) {
            creature.makeMove(map);
        }
    }
}
