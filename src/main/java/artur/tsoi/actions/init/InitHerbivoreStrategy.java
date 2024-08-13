package tsoi.artur.actions.init;

import tsoi.artur.Settings;
import tsoi.artur.entities.animals.Herbivore;
import tsoi.artur.map.Coordinate;
import tsoi.artur.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class InitHerbivoreStrategy implements InitStrategy {
    @Override
    public void init(Map map) {
        int herbivoreMaxCount = Settings.HERBIVORES_MIN_COUNT;
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < herbivoreMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Herbivore herbivore = new Herbivore(coordinate);
            map.spawnEntity(herbivore);
        }
    }
}
