package artur.tsoi.actions.turn;

import artur.tsoi.Settings;
import artur.tsoi.entities.objects.Grass;
import artur.tsoi.map.Coordinate;
import artur.tsoi.map.Map;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class SpawnGrassStrategy implements TurnStrategy {
    @Override
    public void turn(Map map) {
        List<Coordinate> emptyCellsInMatrix = map.getEmptyCellsInMatrix();
        int grassPerTurn = Settings.GRASS_PER_TURN;
        int grassMaxCount = Settings.GRASS_MAX_COUNT;
        int currentGrassCount = map.getEntityCountByClass(Grass.class);

        while (currentGrassCount < grassMaxCount && grassPerTurn > 0) {
            if (emptyCellsInMatrix.isEmpty()) {
                break;
            }

            // Формирование рандомной координаты
            Random random = new Random();
            int randomInt = random.nextInt(emptyCellsInMatrix.size());
            Coordinate coordinate = emptyCellsInMatrix.get(randomInt);

            Grass grass = new Grass(coordinate);
            map.spawnEntity(grass);

            currentGrassCount++;
            grassPerTurn--;
        }
    }
}
