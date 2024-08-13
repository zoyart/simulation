package tsoi.artur.actions.init;

import tsoi.artur.Settings;
import tsoi.artur.entities.objects.Rock;
import tsoi.artur.map.Coordinate;
import tsoi.artur.map.Map;

import java.util.List;
import java.util.Random;

public class InitRockStrategy implements InitStrategy {
    public InitRockStrategy() {}

    @Override
    public void init(Map map) {
        int rockMaxCount = Settings.ROCK_MAX_COUNT;
        List<Coordinate> emptyCells = map.getEmptyCellsInMatrix();

        for (int i = 0; i < rockMaxCount; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(emptyCells.size());
            Coordinate coordinate = emptyCells.get(randomInt);

            Rock rock = new Rock(coordinate);
            map.spawnEntity(rock);
        }
    }
}
