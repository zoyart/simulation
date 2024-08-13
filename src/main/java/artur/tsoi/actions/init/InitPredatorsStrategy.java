package tsoi.artur.actions.init;

import tsoi.artur.Settings;
import tsoi.artur.entities.animals.Predator;
import tsoi.artur.map.Coordinate;
import tsoi.artur.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitPredatorsStrategy implements InitStrategy {
    @Override
    public void init(Map map) {
        int predatorsMaxCount = Settings.PREDATORS_MAX_COUNT;
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < predatorsMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Predator predator = new Predator(coordinate);
            map.spawnEntity(predator);

        }
    }
}
