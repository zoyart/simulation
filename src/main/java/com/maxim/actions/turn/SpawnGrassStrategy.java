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
        Settings settings = Settings.getInstance();

        int grassPerTurn = settings.getGrassPerTurn();
        int grassMaxCount = settings.getGrassMaxCount();
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
