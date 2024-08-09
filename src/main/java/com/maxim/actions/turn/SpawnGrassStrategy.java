package com.maxim.actions.turn;

import com.maxim.Settings;
import com.maxim.entities.objects.Grass;
import com.maxim.map.Coordinate;
import com.maxim.map.Map;
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
