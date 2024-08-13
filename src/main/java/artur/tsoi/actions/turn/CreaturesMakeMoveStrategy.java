package artur.tsoi.actions.turn;

import artur.tsoi.entities.Creature;
import artur.tsoi.entities.animals.Herbivore;
import artur.tsoi.entities.animals.Predator;
import artur.tsoi.map.Map;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class CreaturesMakeMoveStrategy implements TurnStrategy {
    @Override
    public void turn(Map map) {
        List<Predator> predators = map.getAllEntityByClass(Predator.class);
        List<Herbivore> herbivore = map.getAllEntityByClass(Herbivore.class);

        List<Creature> creatures = new LinkedList<>();
        creatures.addAll(predators);
        creatures.addAll(herbivore);

        for (Creature creature : creatures) {
            if (creature.isAlive()) {
                creature.makeMove(map);
            }
        }
    }
}
